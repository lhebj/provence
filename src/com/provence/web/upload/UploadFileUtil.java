
package com.provence.web.upload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.provence.pojo.Content;
import com.provence.web.util.ProvenceConfig;

public class UploadFileUtil {
	
	public static long DEFAULT_MAX_SIZE = 1048576l; //The maximum file size which user can upload
	public static String MESSAGE = "message"; //The the reason for the failure of upload file
	public static String SUCCESS = "success"; // The file whether upload success
	public static String UPLOAD_FILE = "file"; //The instance of FileDetail which stores the detail of upload file
	public static String PATTERN = "yyyy-MM-dd"; //The pattern of date format
	public static String FOLDER = "Folder";
	public static SimpleDateFormat formatterDateFormat = new SimpleDateFormat(PATTERN);
		
	
	public static String getFileDirectoryPath(HttpServletRequest request, String sourceDirectory){
		Date date = new Date();
		String dateSubDirectory = formatterDateFormat.format(date);
		String fileDirectory = request.getRealPath("") + "/" + sourceDirectory + "/" + dateSubDirectory + "/";
		if(!StringUtils.isBlank(ProvenceConfig.FILE_SOURCE_DIRECTORY)){
			fileDirectory = ProvenceConfig.FILE_SOURCE_DIRECTORY + sourceDirectory + "/" + dateSubDirectory + "/";
		}
		return fileDirectory;
	}
	
	public static String getFileAbsoluteDirectoryPath(String sourceDirectory){
		Date date = new Date();
		String dateSubDirectory = formatterDateFormat.format(date);
		String fileDirectory = sourceDirectory + "/" + dateSubDirectory + "/";
		return fileDirectory;
	}
	
	public static String getContentPath(Content content) {
		if (content == null) {
			return null;
		}		
		return ProvenceConfig.STATIC_URL + content.getFilepathCon();
	}
		
	public static Map<String, Map<String, Object>> uploadMultiFile(HttpServletRequest request, String savePath){
		return uploadMultiFile(request, savePath, DEFAULT_MAX_SIZE);
	}
	
	/**
	 * upload file
	 * @param request
	 * @param srcPath
	 * @return 
	 */
	public static Map<String, Map<String, Object>> uploadMultiFile(HttpServletRequest request, String srcPath, long fileMaxSize){
		Map<String, Map<String, Object>> fileMap = new HashMap<String, Map<String, Object>>();
		MultipartRequest multipartRequest = (MultipartRequest)request;
		
		String savePath = getFileDirectoryPath(request, srcPath);
		String absolutePath = getFileAbsoluteDirectoryPath(srcPath);
		System.out.println("savePath"+savePath);
		//if the file folder does not exist, then create it
		File filePath = new File(savePath);
		if (! filePath.exists()) {  
			if (! filePath.mkdirs()){
				Map<String, Object> map = new HashMap<String, Object>();
				String message = "Create folder false!";
				map.put(MESSAGE, message);
				map.put(SUCCESS, Boolean.FALSE);
				fileMap.put(FOLDER, map);
				return fileMap;
			}
        }  
		
		for (Iterator<String>  it = multipartRequest.getFileNames(); it.hasNext();) {  
			String key = it.next();  
			int i = 0;
	        List<MultipartFile> attachmentFileList = multipartRequest.getFiles(key);  
			for (MultipartFile attachmentFile:attachmentFileList){
				Map<String, Object> map = new HashMap<String, Object>();
				if (attachmentFile.getOriginalFilename().length() > 0) {  
		    		long fileSize = attachmentFile.getSize();
		    		
		    		//if the file size is bigger then MAX_SIZE then continue
		    		if (fileSize > fileMaxSize){
		    			String message = "File size " + fileSize + " exceeds the configured maximum " + fileMaxSize;
		    			map.put(MESSAGE, message);
		    			map.put(SUCCESS, Boolean.FALSE);
		    		}else {
		    			String orrginalFileNameString = attachmentFile.getOriginalFilename();
			    		String mimeType= orrginalFileNameString.substring(orrginalFileNameString.lastIndexOf(".") + 1);
			    		UUID uuid = UUID.randomUUID();
			    		String fileName = savePath + uuid.toString() + "." +  mimeType;
			    		File file = new File(fileName);
			    		
			    		try {
			    			attachmentFile.transferTo(file);
				    		Content content = new Content();
				    		content.setFilesizeCon(fileSize);
				    		content.setFilenameCon(file.getName());
				    		content.setOriginalFilenameCon(attachmentFile.getOriginalFilename());
				    		content.setFilepathCon(absolutePath + file.getName());
				    		content.setDateCreateCon(new Date());
				    		content.setMimetypeCon(mimeType);
				    		map.put(MESSAGE, "Save file success!");
				    		map.put(SUCCESS, Boolean.TRUE);
				    		map.put(UPLOAD_FILE, content);
			    		} catch (IOException e) {
			    			e.printStackTrace();
			    			String message = "Save file false!";
			    			map.put(MESSAGE, message);
			    			map.put(SUCCESS, Boolean.FALSE);
			    		}
		    		}
		        }else {
		        	String message = "Upload file is empty!";
	    			map.put(MESSAGE, message);
	    			map.put(SUCCESS, Boolean.FALSE);
		        }
				if (i == 0){
					fileMap.put(key, map);
				}else {
					fileMap.put(key + i, map);
				}
				i++;
			}
	    }  
		return fileMap;
	}
	
	public static Map<String, Object> uploadOneFile (HttpServletRequest request, String srcPath, long fileMaxSize){
		Map<String, Object> map = new HashMap<String, Object>();
		MultipartRequest multipartRequest = (MultipartRequest)request;

		String savePath = getFileDirectoryPath(request, srcPath);
		String absolutePath = getFileAbsoluteDirectoryPath(srcPath);
		
		
		//if the file folder does not exist, then create it
		File filePath = new File(savePath);
		if (! filePath.exists()) {  
			if (! filePath.mkdirs()){
				String message = "Create folder false!";
				map.put(MESSAGE, message);
				map.put(SUCCESS, Boolean.FALSE);
				return map;
			}
        }
		
		for (Iterator<String>  it = multipartRequest.getFileNames(); it.hasNext();) {  
			String key = it.next();  
	        MultipartFile attachmentFile = multipartRequest.getFile(key);
	        if (attachmentFile.getOriginalFilename().length() > 0) {  
	    		long fileSize = attachmentFile.getSize();
	    		
	    		//if the file size is bigger then MAX_SIZE then continue
	    		if (fileSize > fileMaxSize){
	    			String message = "File size " + fileSize + " exceeds the configured maximum " + fileMaxSize;
	    			map.put(MESSAGE, message);
	    			map.put(SUCCESS, Boolean.FALSE);
	    		}else {
	    			String orrginalFileNameString = attachmentFile.getOriginalFilename();
		    		String mimeType= orrginalFileNameString.substring(orrginalFileNameString.lastIndexOf(".") + 1);
		    		UUID uuid = UUID.randomUUID();
		    		String fileName = savePath + uuid.toString() + "." +  mimeType;
		    		File file = new File(fileName);
		    		
		    		try {
		    			attachmentFile.transferTo(file);
		    			Content content = new Content();
			    		content.setFilesizeCon(fileSize);
			    		content.setFilenameCon(file.getName());
			    		content.setOriginalFilenameCon(attachmentFile.getOriginalFilename());
			    		content.setFilepathCon(absolutePath + file.getName());
			    		content.setDateCreateCon(new Date());
			    		content.setMimetypeCon(mimeType);
			    		map.put(MESSAGE, "Save file success!");
			    		map.put(SUCCESS, Boolean.TRUE);
			    		map.put(UPLOAD_FILE, content);
		    		} catch (IOException e) {
		    			e.printStackTrace();
		    			String message = "Save file false!";
		    			map.put(MESSAGE, message);
		    			map.put(SUCCESS, Boolean.FALSE);
		    		}
	    		}
	        }else {
	        	String message = "Upload file is empty!";
    			map.put(MESSAGE, message);
    			map.put(SUCCESS, Boolean.FALSE);
	        }
		}
		return map;
	}
		
	public static Map<String, Object> uploadOneFile(HttpServletRequest request, String savePath){
		return uploadOneFile(request, savePath, DEFAULT_MAX_SIZE);
	}
}
