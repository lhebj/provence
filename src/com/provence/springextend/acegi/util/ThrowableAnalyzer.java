package com.provence.springextend.acegi.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Handler for analyzing {@link Throwable} instances. Can be subclassed to
 * customize its behavior.
 * 
 * @author yeyin
 */
public class ThrowableAnalyzer {

	public static final ThrowableCauseExtractor DEFAULT_EXTRACTOR = new ThrowableCauseExtractor() {
		public Throwable extractCause(Throwable throwable) {
			return throwable.getCause();
		}
	};

	public static final ThrowableCauseExtractor INVOCATIONTARGET_EXTRACTOR = new ThrowableCauseExtractor() {
		public Throwable extractCause(Throwable throwable) {
			verifyThrowableHierarchy(throwable, InvocationTargetException.class);
			return ((InvocationTargetException) throwable).getTargetException();
		}
	};

	private static final Comparator CLASS_HIERARCHY_COMPARATOR = new Comparator() {

		public int compare(Object o1, Object o2) {
			Class class1 = (Class) o1;
			Class class2 = (Class) o2;

			if (class1.isAssignableFrom(class2)) {
				return 1;
			} else if (class2.isAssignableFrom(class1)) {
				return -1;
			} else {
				return class1.getName().compareTo(class2.getName());
			}
		}

	};

	private final Map extractorMap;

	public ThrowableAnalyzer() {
		this.extractorMap = new TreeMap(CLASS_HIERARCHY_COMPARATOR);

		initExtractorMap();
	}

	protected final void registerExtractor(Class throwableType, ThrowableCauseExtractor extractor) {
		verifyThrowableType(throwableType);

		if (extractor == null) {
			throw new IllegalArgumentException("Invalid extractor: null");
		}

		this.extractorMap.put(throwableType, extractor);
	}

	protected void initExtractorMap() {
		registerExtractor(InvocationTargetException.class, INVOCATIONTARGET_EXTRACTOR);
		registerExtractor(Throwable.class, DEFAULT_EXTRACTOR);
	}

	final Class[] getRegisteredTypes() {
		List typeList = new ArrayList(this.extractorMap.keySet());
		return (Class[]) typeList.toArray(new Class[typeList.size()]);
	}

	public final Throwable[] determineCauseChain(Throwable throwable) {
		if (throwable == null) {
			throw new IllegalArgumentException("Invalid throwable: null");
		}

		List chain = new ArrayList();
		Throwable currentThrowable = throwable;

		while (currentThrowable != null) {
			chain.add(currentThrowable);
			currentThrowable = extractCause(currentThrowable);
		}

		return (Throwable[]) chain.toArray(new Throwable[chain.size()]);
	}

	private Throwable extractCause(Throwable throwable) {
		for (Iterator iter = this.extractorMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();

			Class throwableType = (Class) entry.getKey();
			if (throwableType.isInstance(throwable)) {
				ThrowableCauseExtractor extractor = (ThrowableCauseExtractor) entry.getValue();
				return extractor.extractCause(throwable);
			}
		}

		return null;
	}

	public final Throwable getFirstThrowableOfType(Class throwableType, Throwable[] chain) {
		verifyThrowableType(throwableType);

		if (chain != null) {
			for (int i = 0; i < chain.length; ++i) {
				Throwable t = chain[i];

				if ((t != null) && throwableType.isInstance(t)) {
					return t;
				}
			}
		}

		return null;
	}

	private static void verifyThrowableType(Class throwableType) {
		if (throwableType == null) {
			throw new IllegalArgumentException("Invalid type: null");
		}
		if (!Throwable.class.isAssignableFrom(throwableType)) {
			throw new IllegalArgumentException("Invalid type: '" + throwableType.getName() + "'. Has to be a subclass of '" + Throwable.class.getName() + "'");
		}
	}

	public static final void verifyThrowableHierarchy(Throwable throwable, Class expectedBaseType) {
		if (expectedBaseType == null) {
			return;
		}

		if (throwable == null) {
			throw new IllegalArgumentException("Invalid throwable: null");
		}
		Class throwableType = throwable.getClass();

		if (!expectedBaseType.isAssignableFrom(throwableType)) {
			throw new IllegalArgumentException("Invalid type: '" + throwableType.getName() + "'. Has to be a subclass of '" + expectedBaseType.getName() + "'");
		}
	}
}
