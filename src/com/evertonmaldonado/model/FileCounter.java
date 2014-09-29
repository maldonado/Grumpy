package com.evertonmaldonado.model;

public class FileCounter {
	
	private static int correctiveChange = 0;
	private static int adaptativeChange = 0;
	private static int perfectiveChange = 0;
	private static int featureAdditionChange = 0;
	private static int nonFunctionalChange = 0;
	private static int withoutClassificationChange = 0;
	private static int numberOfFilesAnalyzed = 0;
	private static int numberOfCommitMessagesAnalyzed = 0;
	
	public static void incrementCorrectiveChange(){
		correctiveChange ++;
	}
	
	public static void incrementAdaptativeChange(){
		adaptativeChange ++;
	}
	
	public static void incrementPerfectiveChange(){
		perfectiveChange ++;
	}
	
	public static void incrementFeatureAdditionChange(){
		featureAdditionChange ++;
	}
	
	public static void incrementNonFunctionalChange(){
		nonFunctionalChange ++;
	}
	
	public static void incrementWithoutClassificationChange(){
		withoutClassificationChange ++;
	}
	
	public static void incrementNumberOfCommitMessagesAnalyzed(int numberOfCommits){
		numberOfCommitMessagesAnalyzed += numberOfCommits;
	}
	
	public static void incrementNumberOfFilesAnalyzed(){
		numberOfFilesAnalyzed ++;
	}

	public static int getCorrectiveChange() {
		return correctiveChange;
	}

	public static int getAdaptativeChange() {
		return adaptativeChange;
	}

	public static int getPerfectiveChange() {
		return perfectiveChange;
	}
	
	public static int getFeatureAdditionChange() {
		return featureAdditionChange;
	}

	public static int getNonFunctionalChange() {
		return nonFunctionalChange;
	}

	public static int getWithoutClassificationChange() {
		return withoutClassificationChange;
	}

	public static int getNumberOfFilesAnalyzed() {
		return numberOfFilesAnalyzed;
	}

	public static int getNumberOfCommitMessagesAnalyzed() {
		return numberOfCommitMessagesAnalyzed;
	}
}