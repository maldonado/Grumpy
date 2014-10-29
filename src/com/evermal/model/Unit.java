package com.evermal.model;

import java.util.ArrayList;
import java.util.Collection;

public class Unit {

	private String fileName;
	private Collection<String> comments;
	
	public Unit(){
		fileName = null;
		comments =  new ArrayList<String>();
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void addComment(String comment) {
		this.comments.add(comment);
	}

	public Collection<String> getComment() {
		return this.comments;
	}

	public String getFileName() {
		return this.fileName;
	}

}