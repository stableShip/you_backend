package com.easygame.sdk.common.util;


/** apk解析处理类 */
public class ApkUtils {

//	/** 解析apk */
//	public static String parserApk() {
//		return "";
//	}
//
//	/** 反编译apk */
//	public static void decodeApk(File file) {
//		try {
//			ApkDecoder decoder = new ApkDecoder();
//			decoder.setOutDir(new File("/Users/fromgrey/Desktop/"
//					+ file.getName()));
//			decoder.setApkFile(file);
//			decoder.decode();
//		} catch (AndrolibException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void parserAndroidManifestXml(String filePath) {
//		SAXReader reader = new SAXReader();
//		try {
//			Document doc = reader.read(new File(filePath));
//			Element root = doc.getRootElement();
//			System.out.println(root.attributeValue("versionCode"));
//			System.out.println(root.attributeValue("versionName"));
//			System.out.println(root.attributeValue("package"));
//			List<Element> elementList = root.elements();
//			Iterator<Element> it = elementList.iterator();
//			while (it.hasNext()) {
//				Element element = it.next();
//				if ("application".equals(element.getName())) {
//					System.out.println(element.getName() + ":"
//							+ element.attributeValue("label"));
//					System.out.println(element.getName() + ":"
//							+ element.attributeValue("icon"));
//				}
//				if ("uses-permission".equals(element.getName())) {
//					System.out.println(element.getName() + ":"
//							+ element.attributeValue("name"));
//				}
//			}
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//	}
}
