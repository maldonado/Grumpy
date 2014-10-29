package com.evermal.model;

import java.util.Collection;
import java.util.HashSet;

public class Commit {

	private String id;
	private String author;
	private String date;
	private String commitMessage;
	private Collection<Commit> allCommits;

	public Commit(){}

	public Commit(String contentFromFile){
		populateCommitFromFile(contentFromFile);
	}

	public Collection<Commit> getAllCommits(){
		return this.allCommits;
	}

	private void populateCommitFromFile(String contentFromFile) {
		allCommits = new HashSet<Commit>();
		String commitPart = contentFromFile.substring((contentFromFile.indexOf("<BeginOfCommit>") + 15), (contentFromFile.lastIndexOf("<EndOfCommit>")));
		String[] lines =  commitPart.split("\n");
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
				allCommits.add(commit);
			}
		}
	}

	private void setId(String id){
		this.id = id.split("commit")[1].trim();
	}

	public String getId(){
		return this.id;
	}

	public String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		this.author = author.split("Author:")[1].trim();
	}

	public String getDate() {
		return date;
	}

	private void setDate(String date) {
		this.date = date.split("Date:")[1].trim();;
	}

	public String getCommitMessage() {
		return commitMessage;
	}

	private void setCommitMessage(String commitMessage) {
		this.commitMessage = this.commitMessage == null ? commitMessage.trim() : this.commitMessage + commitMessage.trim() ;
	}
}