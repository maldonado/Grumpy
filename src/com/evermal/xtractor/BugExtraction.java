package com.evermal.xtractor;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.lightningbug.api.BugzillaClient;
import de.lightningbug.api.domain.Bug;
import de.lightningbug.api.service.BugService;

public class BugExtraction {

	public void retrieveBug () {


		try{
			//connect to bugzilla
			BugzillaClient client = new BugzillaClient(new URL("https://bugs.eclipse.org/bugs/"), "e_silvam@encs.concordia.ca","bugzilla1");
			if(client.login()){
				System.out.println("logged");
			}
			else{
				System.out.println("not logged");
			}


			//create the bug service
			final BugService bugService = new BugService(client);

			//define the search parameters
			final Map<String, Object[]> searchParams = new HashMap<String, Object[]>();
			searchParams.put("product", new Object[]{"Platform"});
			searchParams.put("status", new Object[]{"CLOSED"});
	        searchParams.put("resolution", new Object[]{"FIXED"});
//			searchParams.put("id", new Object[]{ "48131", "48141", "49052", "1840" });
			//searchParams.put("priority", new Object[]{ "Normal"});

			//search for matching bugs
			final List<Bug> bugs = bugService.search(searchParams);

			for (Bug bug : bugs) {
				
				
//				Integer bugId = (Integer) bug.get("id");
//	            String component = (String) bug.get("component");
//	            String product = (String) bug.get("product");
//	            String resolution = (String) bug.get("resolution");
//	            String status = (String) bug.get("status");
//	            Long reportedlt = ((java.util.Date) bug.get("creation_time")).getTime();
//	            String summary = (String)bug.get("summary");
//	            String assignee = (String)bug.get("assigned_to");
				
//				System.out.println(bug.getStatus());
//				System.out.println(bug.getResolution());
//				System.out.println(bug.getReported());
//				System.out.println(bug.getClosed());
				System.out.println(bug.toString());
//				System.out.println(bug.getAssignee());
			}
			
		} catch (Exception e ){
			
		}
	}
}
