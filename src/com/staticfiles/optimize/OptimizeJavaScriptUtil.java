package com.staticfiles.optimize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.yahoo.platform.yui.compressor.YUICompressor;

public class OptimizeJavaScriptUtil {
	private static final String ORIGINAL_DIRECTORY = "../../static/src_js";
	private static final String DESTINATION_DIRECTORY = "../../static/js_optimize";
	private static final String YUICOMPRESSOR_JAR_FILE_PATH = "../lib/yuicompressor-2.3.6.jar";
	private static final String MERGECONFIGFILE_PATH = "com/staticfiles/optimize/Compressor.xml";
	private static URL YUICOMPRESSOR_JAR_FILE_LOCATION = null;
	
	static {
		try {
			YUICOMPRESSOR_JAR_FILE_LOCATION = ClassLoaderUtil.getExtendResource(YUICOMPRESSOR_JAR_FILE_PATH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private static void mergeFiles(final List<File> originalFiles, final File targetFile) throws IOException {
		if (targetFile.exists() == false)
			targetFile.createNewFile();
		RandomAccessFile outt = new RandomAccessFile(targetFile, "rw");
		for (File originalFile : originalFiles) {
			System.out.println("Merge File: "+ originalFile.getAbsolutePath() + " into "+ targetFile.getAbsolutePath());
			RandomAccessFile inn = new RandomAccessFile(originalFile, "r");
			int c;
			while ((c = inn.read()) != -1)
				outt.write(c);
			inn.close();
		}
		outt.close();
	}

	private static void batchMergeFiles() throws JDOMException, IOException {
		SAXBuilder sb = new SAXBuilder();	
		Document doc = sb.build(new File(ClassLoaderUtil.getExtendResource(MERGECONFIGFILE_PATH).getPath()));
		Element root = doc.getRootElement();
		List mergeList = root.getChildren();
		for (Object object : mergeList) {
			Element element = (Element) object;
			Element jsFilesElement = element.getChild("JSFiles");
			List jsFileList = jsFilesElement.getChildren("JSFile");
			List<File> originalFileList = new ArrayList<File>();
			for (Object jsFileObject : jsFileList) {
				Element jsFile = (Element) jsFileObject;
				Attribute ref_attribute = jsFile.getAttribute("ref");
				String refUrl = ref_attribute.getValue();
				String realRefUrl = "../../" + refUrl;
				originalFileList.add(new File(ClassLoaderUtil.getExtendResource(realRefUrl).getPath()));
			}
			Element jsCompressFileElement = element.getChild("JSCompressFile");
			Attribute jsCompressFileRef = jsCompressFileElement.getAttribute("ref");
			String targetRefUrl = jsCompressFileRef.getValue();
			String realTargetRefUrl = "../../" + targetRefUrl;
			File targetFile = new File(ClassLoaderUtil.getExtendResource(realTargetRefUrl).getPath());
			if (targetFile.exists()) {
				targetFile.delete();
			}
			mergeFiles(originalFileList, targetFile);
		}
	}

	private synchronized static void batchOptimize(final File tmpFile, final File targetFile, boolean isOptimizeIgnoreFolder) throws IOException {
		List<String> optimizeIgnoreFolders = new ArrayList<String>();
		optimizeIgnoreFolders.add("tinymce");
		optimizeIgnoreFolders.add("calendar");
		optimizeIgnoreFolders.add("flowplayer3.1");
		optimizeIgnoreFolders.add("ipdf");
		optimizeIgnoreFolders.add("documentPlayer");
		optimizeIgnoreFolders.add("ableskyPlayer");
		optimizeIgnoreFolders.add("common");
		
		List<String> optimizeIgnoreFiles = new ArrayList<String>();
		optimizeIgnoreFiles.add("jquery.js");
		optimizeIgnoreFiles.add("jquery.mousewheel.js");
		optimizeIgnoreFiles.add("jquery.slides.js");
		
		String jarFileLocation = YUICOMPRESSOR_JAR_FILE_LOCATION.getPath();
		if (tmpFile.isDirectory()) {
			if (targetFile.exists() == false) {
				targetFile.mkdir();
			}
			File[] fileList = tmpFile.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				String subDirectory = targetFile.getAbsolutePath() + "\\" + fileList[i].getName();
				System.out.println("next directory:" + subDirectory);
				
				isOptimizeIgnoreFolder = optimizeIgnoreFolders.contains(tmpFile.getParentFile().getName()) || isOptimizeIgnoreFolder;
				batchOptimize(fileList[i], new File(subDirectory), isOptimizeIgnoreFolder);
			}
		} else {
			// only optimize the modified js
			if (targetFile.exists() && tmpFile.lastModified() < targetFile.lastModified()) {
				return;
			}
			if (targetFile.exists()) {
				targetFile.delete();
			}

			
			// do not optimize no-js based file
			if (tmpFile.getName().endsWith(".js") && !isOptimizeIgnoreFolder && !optimizeIgnoreFiles.contains(tmpFile.getName())) {
				String commandString = "java -jar " + jarFileLocation.substring(1, jarFileLocation.length()) + " --charset utf8 " + tmpFile.getAbsolutePath() + " -o " + targetFile.getAbsolutePath();
				System.out.println("command: " + commandString);
				String args[] = { "--charset", "utf8", tmpFile.getAbsolutePath(), "-o", targetFile.getAbsolutePath() };
				YUICompressor.main(args);
			} else {
				copyFile(targetFile, tmpFile);
			}

		}
	}

	public static void copyFile(File targetFile, File file) {		
		try {
			targetFile.createNewFile();
			System.out.println("copy file " + file.getAbsolutePath() + " to " + targetFile.getAbsolutePath());
			InputStream is = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(targetFile);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			is.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, JDOMException {
		System.out.println("!------------------------ Start Optimize ----------------------!");
		File originalDirectory = new File(ClassLoaderUtil.getExtendResource(ORIGINAL_DIRECTORY).getPath());
//		File originalDirectory = new File(ClassLoaderUtil.getExtendResource("../../js/tinymce/langs").getPath());
		File targetDirectory = new File(ClassLoaderUtil.getExtendResource(DESTINATION_DIRECTORY).getPath());
		batchOptimize(originalDirectory, targetDirectory, false);
		batchMergeFiles();
		
		System.out.println("!------------------------ ALL Done ----------------------!");
	}
}
