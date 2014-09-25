package com.evertonmaldonado.model;


public class Commit {

	private String id;
	private String author;
	private String date;
	private String commitMessage;

	public void setId(String id){
		this.id = id.split("commit")[1].trim();
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author.split("Author:")[1].trim();
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date.split("Date:")[1].trim();;
	}
	
	public String getCommitMessage() {
		return commitMessage;
	}
	
	public void setCommitMessage(String commitMessage) {
		this.commitMessage = this.commitMessage == null ? commitMessage.trim() : this.commitMessage + commitMessage.trim() ;
	}
}