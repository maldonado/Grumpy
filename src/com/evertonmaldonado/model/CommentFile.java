package com.evertonmaldonado.model;

import java.util.StringTokenizer;

import com.evertonmaldonado.exception.CommentFileInitializationException;

public class CommentFile {

	private String absoluteFileName;
	private String fileName;
	private String directory;
	private String content;


	public CommentFile(String fileContent){
		setUpClassAtributes(fileContent);
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


	private void setUpClassAtributes(String fileContent) {
		try{
			String contentWithoutLineBreakers = fileContent.replaceAll("(\\r|\\n)","").trim();
			String[] filePart = contentWithoutLineBreakers.split("<BeginOfFile>");
			if(filePart.length < 2) {
				throw new CommentFileInitializationException(contentWithoutLineBreakers);
			}
			absoluteFileName = filePart[0];
			setContent(filePart[1]);
			setFileName();
			setDirectory();
		}catch(CommentFileInitializationException ex){
			System.out.println(ex.getMessage());
		}
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

	private void setContent(String fileContent) {
		content = fileContent;
	}

	private void setDirectory() {
		String[] directoryPart =  this.absoluteFileName.split(this.fileName);
		directory = directoryPart[0];
	}
}