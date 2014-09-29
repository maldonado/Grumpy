package com.evertonmaldonado.model;

import java.util.Collection;

public class CommitFile extends FileFromText{

	private Collection<Commit> commits;
	
	public CommitFile(String textFileContent) {
		super(textFileContent);
		setCommits();
		FileCounter.incrementNumberOfCommitMessagesAnalyzed(commits.size());
	}

	public Collection<Commit> getCommits(){
		return commits;
	}
	
	private void setCommits(){
		commits = new Commit(content).getAllCommits();
	}
}