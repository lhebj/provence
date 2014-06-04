package com.provence.springextend.acegi.util;

/**
 * Interface for handlers extracting the cause out of a specific.
 * 
 * @author yeyin
 * 
 * @see ThrowableAnalyzer
 */
public interface ThrowableCauseExtractor {

	Throwable extractCause(Throwable throwable);
}
