package com.evertonmaldonado.model;

import java.util.StringTokenizer;

import com.evertonmaldonado.exception.FileInitializationException;

public abstract class FileFromText {
	
	protected String absoluteFileName;
	protected String content;
	protected String directory;
	protected String fileName;
	
	public FileFromText(String textFileContent){
		try{
			setAbsoluteFileName(textFileContent);
			setContent(textFileContent);
			setFileName();
			setDirectory();
			FileCounter.incrementNumberOfFilesAnalyzed();
		}catch(Exception ex){
			throw new FileInitializationException(textFileContent);
		}
	}
	
	public String getAbsoluteFileName() {
		return absoluteFileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getDirectory() {
		return directory;
	}
	
	public String getContent() {
		return content;
	}
	
	private void setAbsoluteFileName(String textFileContent) {
		this.absoluteFileName = textFileContent.replaceAll("(\\r|\\n)","").trim().split("<BeginOfFile>")[0];
	}
	
	private void setContent(String textFileContent) {
		this.content = textFileContent.split("<BeginOfFile>")[1];
	}
	
	private void setFileName() {
		StringTokenizer tokens = new StringTokenizer(this.absoluteFileName, "/", false);
		while(tokens.hasMoreTokens()){
			if(tokens.countTokens() == 1 ){ 
				fileName = tokens.nextToken().trim();
				break;
			}
			tokens.nextToken();
		}
	}
	
	private void setDirectory() {
		String[] directoryPart =  this.absoluteFileName.split(this.fileName);
		directory = directoryPart[0];
	}
}