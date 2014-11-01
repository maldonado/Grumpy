package com.evermal.model;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

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

	//	TODO: BUGID TO STRING TO DISPLAY PROPERLY in eclipse bug to avoid this abstracted methods here; 
	public String calculateDeltasOfBugLifesCycle(){
		
		String bugIdAsString = getBugidAsString(); 
		
		DateTime jodaCreationDate = new DateTime(creationDate);
		DateTime jodaCommitedDate = new DateTime(commitedDate);
		DateTime jodaResolvedDate = new DateTime(resolvedDate);
		
		Days firstDelta  = Days.daysBetween(jodaCreationDate, jodaCommitedDate);
		Days secondDelta = Days.daysBetween(jodaCommitedDate, jodaResolvedDate);
		Days thirdDelta  = Days.daysBetween(jodaCreationDate, jodaResolvedDate);
		
//		if(resolvedDate != null){
//			long resolvedDateMilli = this.resolvedDate.getTime();
//			secondDelta = (((resolvedDateMilli - commitedDateMilli)/1000)/60)/24;
//			thirdDelta = (((resolvedDateMilli - creationDateMilli)/1000)/60)/24;
//		}
		StringBuilder sb = new StringBuilder();
//		sb.append("\t");
//		sb.append("C~CO");
//		sb.append("\t\t");
//		sb.append("CO~RE");
//		sb.append("\t\t");
//		sb.append("C~RE");
//		sb.append("\n");
//		sb.append("\t");
//		sb.append("\n");
		sb.append(bugIdAsString);
		sb.append(";");
		sb.append(firstDelta.getDays());
//		sb.append("\t\t");
		sb.append(";");
		sb.append(secondDelta.getDays());
//		sb.append("\t\t");
		sb.append(";");
		sb.append(thirdDelta.getDays());
		return   sb.toString();
//		return "Difference between creation and commit of "+firstDelta.getDays()+", and between commit and solution "+secondDelta.getDays()+". Total life cycle "+thirdDelta.getDays();
	}

	public abstract String getBugidAsString();
	
}