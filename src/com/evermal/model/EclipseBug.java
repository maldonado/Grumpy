package com.evermal.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EclipseBug extends Bug{

	private long id;
	private String product;
	private String component;
	private String assignee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProduct() {
		return product;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getComponent() {
		return component;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public void save() {
		String sql = "INSERT INTO httpdbugs (bugid, product, component, status, resolution, summary, assignee, creationdate, commitedDate, resolvedDate) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, getId());
			ps.setString(2, getProduct());
			ps.setString(3, getComponent());
			ps.setString(4, getStatus());
			ps.setString(5, getResolution());
			ps.setString(6, getSummary());
			ps.setString(7, getAssignee());
			ps.setTimestamp(8, getCreationDate());
			ps.setTimestamp(9, getCommitedDate());
			ps.setTimestamp(10, getResolvedDate());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<EclipseBug> findAll(){
		try {
			ArrayList<EclipseBug> allBugs = new ArrayList<EclipseBug>();
			String sql = "SELECT * FROM httpdbugs";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				EclipseBug bug = new EclipseBug();
				bug.setId(result.getLong("bugid"));
				bug.setProduct(result.getString("product"));
				bug.setComponent(result.getString("component"));
				bug.setStatus(result.getString("status"));
				bug.setResolution(result.getString("resolution"));
				bug.setSummary(result.getString("summary"));
				bug.setAssignee(result.getString("assignee"));
				bug.setCreationDate(result.getTimestamp("creationdate"));
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
}