package com.provence.web.util;

import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.provence.pojo.Content;

/**
 * 
 * 修改的时候注意其他工程的该类的相应修改
 * @version 1.0.0 PhotoUtil.java Jun 3, 2013 4:02:45 PM
 */
public class PhotoUtil {
	public static final Log log = LogFactory.getLog(PhotoUtil.class);
	public static String DEFAULT_ACCOUNT_PHOTO = "/images/init/defaultPerson.gif";

//	public static String getStaticServerLocationById(Long id){
//		List<String> picLocationList = ProvenceConfig.STATICSERVER_PIC_LOCATION_LIST;
//		if(picLocationList == null || picLocationList.size() == 0){
//			return ProvenceConfig.STATICSERVER_PIC_LOCATION;
//		}
//		int size = picLocationList.size();
//		if(id == null) {
//			id = 0L;
//		}
//		Long pos = id % size;
//		return picLocationList.get(pos.intValue());
//	}
	
	/**
	 * @param content
	 * @param type
	 *            LinkGenerator.type
	 * @return
	 */
	public static String getContentPhotoPath(Content content, String type) {
		if (content == null || type == null) {
			return null;
		}
		return null;
	}
	
	public static String getRandomImage() {
		Random random = new Random();
		int intNumber = random.nextInt(4);
		return "user-default-" + intNumber + ".png";
	}
	
}
