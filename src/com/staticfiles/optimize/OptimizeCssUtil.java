package com.staticfiles.optimize;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.yahoo.platform.yui.compressor.YUICompressor;

public class OptimizeCssUtil {
	private static final String ORIGINAL_DIRECTORY = "../../static/src_css";
	private static final String DESTINATION_DIRECTORY = "../../static/stylecss_optimize";
	private static final String YUICOMPRESSOR_JAR_FILE_PATH = "../lib/yuicompressor-2.3.6.jar";
	private static URL YUICOMPRESSOR_JAR_FILE_LOCATION = null;
	static {
		try {
			YUICOMPRESSOR_JAR_FILE_LOCATION = ClassLoaderUtil.getExtendResource(YUICOMPRESSOR_JAR_FILE_PATH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private static void batchOptimize(final File tmpFile, final File targetFile) throws IOException {
		String jarFileLocation = YUICOMPRESSOR_JAR_FILE_LOCATION.getPath();
		Runtime run = Runtime.getRuntime();
		if (tmpFile.isDirectory()) {
			if (targetFile.exists() == false) {
				targetFile.mkdir();
			}
			File[] fileList = tmpFile.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				String subDirectory = targetFile.getAbsolutePath() + "\\" + fileList[i].getName();
				System.out.println("next directory:" + subDirectory);
				batchOptimize(fileList[i], new File(subDirectory));
			}
		} else {
			// only optimize the modified js
			if (targetFile.exists() && tmpFile.lastModified() < targetFile.lastModified()) {
				return;
			}

			// do not optimize no-css based file
			if (!tmpFile.getName().contains(".css"))
				return;
			if (targetFile.exists())
				targetFile.delete();
			String args[] = { "--charset", "utf8", "--type", "css", tmpFile.getAbsolutePath(), "-o", targetFile.getAbsolutePath() };
			String commandString = "java -jar " + jarFileLocation.substring(1, jarFileLocation.length()) + " --charset utf8 --type css " + tmpFile.getAbsolutePath() + " -o " + targetFile.getAbsolutePath();
			System.out.println("command: " + commandString);
			YUICompressor.main(args);
		}
	}

	public static void main(String[] args) {
		File originalDirectory;
		try {
			originalDirectory = new File(ClassLoaderUtil.getExtendResource(ORIGINAL_DIRECTORY).getPath());
			File targetDirectory = new File(ClassLoaderUtil.getExtendResource(DESTINATION_DIRECTORY).getPath());
			batchOptimize(originalDirectory, targetDirectory);
			System.out.println("!------------------------ CSS OPTIMIZE Done ----------------------!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
