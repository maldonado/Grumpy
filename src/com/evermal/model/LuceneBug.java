package com.evermal.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LuceneBug extends Bug{
	
	private String id;
	private String priority;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public List<LuceneBug> findAll(){
		try {
			ArrayList<LuceneBug> allBugs = new ArrayList<LuceneBug>();
			String sql = "SELECT * FROM lusene_found_issues";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				LuceneBug bug = new LuceneBug();
				bug.setId(result.getString("bugid"));
				bug.setPriority(result.getString("priority"));
				bug.setStatus(result.getString("status"));
				bug.setResolution(result.getString("resolution"));
				bug.setSummary(result.getString("summary"));
				bug.setCreationDate(result.getTimestamp("creationDate"));
				bug.setCommitedDate(result.getTimestamp("commitedDate"));
				bug.setResolvedDate(result.getTimestamp("resolvedDate"));
				allBugs.add(bug);
			}
			return allBugs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String getBugidAsString() {
		return id;
	}
}