package com.evertonmaldonado.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import com.evertonmaldonado.exception.CommentFileInitializationException;

public class CommitFile {

	private String absoluteFileName;
	private String fileName;
	private String directory;
	private String content;

	private Collection<Commit> commits;


	public CommitFile(String fileContent){
		commits = new ArrayList<Commit>();
		setUpClassAtributes(fileContent);
		FileCounter.incrementNumberOfFilesAnalyzed();
		for (Commit commit : commits) {
			FileCounter.incrementNumberOfCommitMessagesAnalyzed();
		}
	}

	public Collection<Commit> getCommits(){
		return commits;
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
			setContent(fileContent);
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
		content = fileContent.substring((fileContent.indexOf("<BeginOfCommit>") + 15), (fileContent.lastIndexOf("<EndOfCommit>")) );
//		content.replaceAll("<BeginOfCommit>", "");
//		content.replaceAll("<EndOfCommit>", "");
		String[] lines =  content.split("\n");
		for (int i = 0; i < lines.length ; i++) {
			if(lines[i].startsWith("commit")){
				Commit commit = new Commit();
				commit.setId(lines[i]);
				for(int j = i+1; j < lines.length ; j++){
					i = j;
					if(lines[j].startsWith("commit")){
						i--;
						break;
					}if(lines[j].startsWith("Author")){
						commit.setAuthor(lines[j]);
					}else if(lines[j].startsWith("Date")){
						commit.setDate(lines[j]);
					}else{
						commit.setCommitMessage(lines[j]) ;	
					}
				}
				commits.add(commit);
			}
		}
	}

	private void setDirectory() {
		String[] directoryPart =  this.absoluteFileName.split(this.fileName);
		directory = directoryPart[0];
	}
}
