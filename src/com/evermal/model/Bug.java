package com.evermal.model;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

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
	
	public String calculateDeltasOfBugLifesCycle(){
		long firstDelta = 0;
		long secondDelta = 0;
		long thirdDelta = 0;
		long commitedDateMilli = 0;
		long creationDateMilli = this.creationDate.getTime();
		
		if(commitedDate != null){
			commitedDateMilli = this.commitedDate.getTime();
			firstDelta = (((commitedDateMilli - creationDateMilli)/1000)/60)/24;
		}
		if(resolvedDate != null){
			long resolvedDateMilli = this.resolvedDate.getTime();
			secondDelta = (((resolvedDateMilli - commitedDateMilli)/1000)/60)/24;
			thirdDelta = (((resolvedDateMilli - creationDateMilli)/1000)/60)/24;
		}
		
		return String.format("Difference between creation and commit of {0}, and between commit and solution {1}. Total difference {2}", firstDelta, secondDelta, thirdDelta );
	}
}