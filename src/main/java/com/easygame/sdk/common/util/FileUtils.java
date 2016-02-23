package com.easygame.sdk.common.util;

import java.io.File;

public class FileUtils {

	public static String basePhysicalPath = "";

	/**
	 * 获取物理根路径（linux，window通用）
	 * 
	 * @return
	 */
	public static String getBasePhysicalPath() {
		
		if (basePhysicalPath != null && !"".equals(basePhysicalPath)) {
			return basePhysicalPath;
		}

		String originalBasePath = Thread.currentThread().getContextClassLoader().getResource("") + "";

		String str[] = originalBasePath.split("\\/");
		for (int j = str.length - 3; j < str.length - 2; j--) {
			
			if (str[j].matches("[A-Za-z]{1}\\:")) {
				
				basePhysicalPath = str[j] + basePhysicalPath + "/";
				break;
				
			}
			
			if (str[j].endsWith("file:")) {
				
				basePhysicalPath = basePhysicalPath + "/";
				break;
				
			}
			
			basePhysicalPath = "/" + str[j] + basePhysicalPath;
			
		}
		
		return basePhysicalPath;
		
	}

	public static boolean createDirectory(String dirName) {
		
		File dirs = new File(dirName);
		if (dirs.exists()) {
			
			return false;
			
		} else {
			
			dirs.mkdirs();
			
			return true;
			
		}
		
	}

}
