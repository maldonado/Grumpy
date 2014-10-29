package com.evermal.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {

	private static final String HACK_PATTERN_FILE = "_hack_pattern.txt";
	private static final String COMMENTS_FILE = "_comments.txt";
	private static final String STATISTIC_FILE = "_statistc.txt";
	private static final String CORRECTIVE_CHANGE = "_corrective_change.txt";
	private static final String ADAPTATIVE_CHANGE = "_adaptative_change.txt";
	private static final String PERFECTIVE_CHANGE = "_perfective_change.txt";
	private static final String FEATURE_ADDITION_CHANGE = "_feature_addition_change.txt";
	private static final String NON_FUNCTIONAL_CHANGE = "_non_functional_change.txt";
	private static final String HACK_PATTERN_OVERLAP = "_hack_pattern_overlap.txt";
	
	private static final String XML_EXTENSION = ".xml";
	private static final String TXT_EXTENSION = ".txt";
	
	private static Properties properties = getProperties("grumpy.properties");

	public static String[] getFilesInParsedCodeFolder() throws IOException{
		return returnListOfFiles("parsed.code.directory", XML_EXTENSION);
	}
	
	public static String[] getFilesInExtractedCommentsFolder() {
		return returnListOfFiles("extracted.comments.directory", TXT_EXTENSION);
	}
	
	public static String[] getFilesInHackPatternFolder() {
		return  returnListOfFiles("hack.pattern.directory", TXT_EXTENSION);
	}

	private static String[] returnListOfFiles(String propertyName, String extension) {
		String folder = properties.getProperty(propertyName);
		File directory = new File(folder);
		String[] list = directory.list(getExtensionFileFilter(extension));
		for (int i = 0; i < list.length; i++) {
			list[i] = folder.concat(list[i]);
		}
		return list;
	}

	public static String getCommentFileName(String filePath) throws IOException {
		return getFileName(filePath, "extracted.comments.directory", COMMENTS_FILE);
	}
	
	public static String getHackPatternFileName(String filePath) throws IOException {
		return getFileName(filePath, "hack.pattern.directory", HACK_PATTERN_FILE);
	}
	
	public static String getStatisticFileName(String filePath) throws IOException {
		return getFileName(filePath, "statistics.directory", STATISTIC_FILE);
	}
	
	public static String getCorrectiveChangeFileName(String commentFile) throws IOException {
		return getFileName(commentFile, "change.classification.directory", CORRECTIVE_CHANGE);
	}
	
	public static String getAdaptativeChangeFileName(String commentFile) throws IOException {
		return getFileName(commentFile, "change.classification.directory", ADAPTATIVE_CHANGE);
	}
	
	public static String getPerfectiveChangeFileName(String commentFile) throws IOException {
		return getFileName(commentFile, "change.classification.directory", PERFECTIVE_CHANGE);
	}
	
	public static String getFeatureAdditionChangeFileName(String commentFile) throws IOException {
		return getFileName(commentFile, "change.classification.directory", FEATURE_ADDITION_CHANGE);
	}
	
	public static String getNonFunctionalChangeFileName(String commentFile) throws IOException {
		return getFileName(commentFile, "change.classification.directory", NON_FUNCTIONAL_CHANGE);
	}
	
	public static String getHackPatternOverlapFileName(String filePath) throws IOException {
		return getFileName(filePath, "change.classification.directory", HACK_PATTERN_OVERLAP);
	}
	
	private static String getFileName(String filePath, String propertyName, String extension) {
		File file = new File(filePath);
		String fileName = file.getName();
		int substringIndex = fileName.indexOf("_");
		if(substringIndex == -1)
			substringIndex = fileName.indexOf("." );
		String outputFile =  fileName.substring(0, substringIndex);
		return properties.getProperty(propertyName).concat(outputFile.concat(extension));
	}
	
	public static void WriteOrUpdateFile(String fileName, String content){
		try {
			org.apache.commons.io.FileUtils.write(org.apache.commons.io.FileUtils.getFile(fileName), content, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Properties getProperties(String propsFileName) {
		try{
			Properties props = new Properties(System.getProperties());
			props.load(new FileInputStream(propsFileName));
			for (Object propertie : props.keySet()) {
				String property = props.getProperty(propertie.toString());
				if(property == null || property.isEmpty())
					throw new IOException("Missing property name :" + propertie.toString());

				return props;
			}

		}catch(IOException e ){
			System.out.println(e);
		}
		return null;
	}
	
	private static FilenameFilter getExtensionFileFilter(final String extension){
		FilenameFilter txtFileFilter = new FilenameFilter(){
			public boolean accept(File dir, String name){
				return name.endsWith(extension);
			}
		};
		return txtFileFilter;
	}
}