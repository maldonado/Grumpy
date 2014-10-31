package com.evermal.model;

import java.sql.Connection;
import java.sql.Timestamp;

import com.evermal.utils.ConnectionFactory;

public abstract class Bug {

	protected Connection connection;
	
	private String status;
	private String resolution;
	private String summary;
	protected Timestamp creationDate;
	protected Timestamp commitedDate;
	protected Timestamp resolvedDate;
	
	public Bug(){
		this.connection = ConnectionFactory.getConnection();
	}
	
	public String getResolution() {
		return resolution;
	}
	
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setCreationdate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	
	public void setResolvedDate(Timestamp resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getCommitedDate() {
		return commitedDate;
	}

	public void setCommitedDate(Timestamp commitedDate) {
		this.commitedDate = commitedDate;
	}

	public Timestamp getResolvedDate() {
		return resolvedDate;
	}

}