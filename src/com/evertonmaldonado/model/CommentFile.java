package com.evertonmaldonado.model;

import java.util.StringTokenizer;

public class CommentFile {

	private String absoluteFileName;
	private String fileName;
	private String directory;
	private String content;


	public CommentFile(String fileContent){
		setAbsoluteFileName(fileContent);
//		setContent(fileContent);
//		setFileName();
		//		setDirectory();

	}

	public String getAbsoluteFileName() {
		return this.absoluteFileName;
	}

	public String getFileName(){
		return this.fileName;
	}

	public String getDirectory(){
		return this.directory;
	}

	public String getContent(){
		return this.content;
	}


	private void setAbsoluteFileName(String fileContent) {
		String contentWithoutLineBreakers = fileContent.replaceAll("(\\r|\\n)","").trim();
		String[] filePart = contentWithoutLineBreakers.split("<BeginOfFile>");
		absoluteFileName = filePart[0];
		setContent(filePart[1]);
		setFileName();
		setDirectory();
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

	//	TODO: CAN TURN INTO A COLLECTION OF STRINGS
	private void setContent(String fileContent) {
//		StringBuffer sb = new StringBuffer();
//		for(String line : fileContent.split(this.absoluteFileName)){
//			sb.append(line);
//		}
		content = fileContent;
	}

	private void setDirectory() {
//		StringBuffer sb = new StringBuffer();
//		for(String line : this.absoluteFileName.split(this.fileName)){
//			sb.append(line);
//		}
//		directory = sb.toString();
		String[] directoryPart =  this.absoluteFileName.split(this.fileName);
		directory = directoryPart[0];
	}
}