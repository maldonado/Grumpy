package com.evermal.execution;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.evermal.model.FileCounter;
import com.evermal.utils.FileUtils;
import com.evermal.xtractor.BugExtraction;
import com.evermal.xtractor.HackWordMatcher;
import com.evermal.xtractor.MaintenanceClassifierWordMatcher;
import com.evermal.xtractor.XmlFileReader;

public class ProjectAnalyzer {

	public static void main(String[] args) {
		try {
			
//			createCommentFileFromParsedCode();
//			createHackPatternFileFromCommentedCode();
			createCommitClassificationFileFromHackPatternFile();
			
//			BugExtraction bug = new BugExtraction();
//			bug.retrieveBug();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createCommentFileFromParsedCode() throws Exception {
		System.out.println("Creating extracted comments file ...");
		String[] fillesInParsedCodeFolder = FileUtils.getFilesInParsedCodeFolder();
		int progressCounter = 0;
		for (String parsedFile : fillesInParsedCodeFolder) {
			System.out.println("processing " + parsedFile);
			XmlFileReader reader = new XmlFileReader();
			String commentsOfFile = reader.readXML(parsedFile); 
			FileUtils.WriteOrUpdateFile(FileUtils.getCommentFileName(parsedFile), commentsOfFile);
			progressCounter ++;
			System.out.println( progressCounter + " out of " + fillesInParsedCodeFolder.length);
		}
	}

	private static void createHackPatternFileFromCommentedCode() throws IOException{
		System.out.println("Creating hack patterns file ...");
		String[] fillesInExtractedCommentsFolder = FileUtils.getFilesInExtractedCommentsFolder();
		int progressCounter = 0;
		for (String commentFile : fillesInExtractedCommentsFolder) {
			System.out.println("processing " + commentFile);
			FileCounter.reset();
			HackWordMatcher matcher = new HackWordMatcher();
			String hackPatternFile = matcher.proccess(commentFile);
			FileUtils.WriteOrUpdateFile(FileUtils.getHackPatternFileName(commentFile), hackPatternFile);
			FileUtils.WriteOrUpdateFile(FileUtils.getStatisticFileName(commentFile), "Total number of analyzed files " + FileCounter.getNumberOfFilesAnalyzed());
			progressCounter ++;
			System.out.println( progressCounter + " out of " + fillesInExtractedCommentsFolder.length);
		}
	}

	private static void createCommitClassificationFileFromHackPatternFile() throws IOException  {
		System.out.println("Creating change classification files ...");
		String[] filesInHackPatternFolder = FileUtils.getFilesInHackPatternFolder();
		int progressCounter = 0;
		for (String hackPatternFile : filesInHackPatternFolder) {
			System.out.println("processing " + hackPatternFile);
			FileCounter.reset();
			MaintenanceClassifierWordMatcher maintenanceClassifier = new MaintenanceClassifierWordMatcher();
			maintenanceClassifier.processFile(hackPatternFile);
			progressCounter ++;
			System.out.println( progressCounter + " out of " + filesInHackPatternFolder.length);
		}
	}
}