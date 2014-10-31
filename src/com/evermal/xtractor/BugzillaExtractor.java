package com.evermal.xtractor;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

import com.evermal.model.EclipseBug;

public class BugzillaExtractor {

	private static final String PROPERTIES_FILE = "grumpy.properties";
	private XmlRpcClient rpcClient;
	private Properties properties;


	public BugzillaExtractor(){
		setupProperties();
	}

	public void retrieveBug () {
		try {
			setupRPCClient();
			loginBugzilla();
			Map <String, Object[]>  searchParams = new HashMap<String, Object[]>();
			// Object[] products = {"Platform"};
			// Object[] status = {"CLOSED"};
			// searchParams.put("product", products);
			// searchParams.put("status", status);
			Object[] id = {"49380","211447","43952","122442","264238","112774","48131","298510","81140","49383","55435","357547","183463","209706","311582","123375","102780","371233","34548","252677","259687","311617","57455","402028","153500","209872","48141","61553","317706","360044","212389","318759","350103","401030","40255","209836","61270","109878","180921","213297","72566","53565","243441","250794","227043"};
			searchParams.put("id", id);
			searchBugs(searchParams);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setupRPCClient() throws MalformedURLException {
		System.out.println("configuring rcpClient...");
		HttpClient httpClient = new HttpClient();
		rpcClient = new XmlRpcClient();
		XmlRpcCommonsTransportFactory factory = new XmlRpcCommonsTransportFactory(rpcClient);
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		
		factory.setHttpClient(httpClient);
		rpcClient.setTransportFactory(factory);
		String wsurl = properties.getProperty("bugzilla.wsurl");
		config.setServerURL(new URL(wsurl));
		rpcClient.setConfig(config);
		System.out.println("rcpClient configured.");
	}

	private void loginBugzilla() throws XmlRpcException {
		System.out.println("connecting to bugzilla...");
		Map<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("login", properties.getProperty("bugzilla.wsuser"));
		loginMap.put("password", properties.getProperty("bugzilla.wspw"));
		loginMap.put("rememberlogin", "Bugzilla_remember");
		rpcClient.execute("User.login", new Object[]{loginMap});
		System.out.println("connected to bugzilla...");
	}

	private void searchBugs(Map<String, Object[]> searchParams) {
		try {
			System.out.println("Searching for bugs ...");
			Map searchResult = (Map) rpcClient.execute("Bug.search", new Object[]{searchParams});
			Object[] bugs = (Object[]) searchResult.get("bugs");
			System.out.println("Done ...");
			for (int i = 0; i < bugs.length; i++) {
				HashMap bug = (HashMap) bugs[i];
				Long reportedlt = ((java.util.Date) bug.get("creation_time")).getTime();
				Long lastChangeTime = ((java.util.Date) bug.get("last_change_time")).getTime();
				createEclipseBug(bug, reportedlt, lastChangeTime);
			}
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
	}

	private void createEclipseBug(HashMap bug, Long reportedlt, Long lastChangeTime) {
		EclipseBug eclipseBug = new EclipseBug();
		eclipseBug.setId((Integer) bug.get("id"));
		eclipseBug.setComponent((String) bug.get("component"));
		eclipseBug.setProduct((String) bug.get("product"));
		eclipseBug.setResolution((String) bug.get("resolution"));
		eclipseBug.setStatus((String) bug.get("status"));
		eclipseBug.setCreationdate(new Timestamp(reportedlt));
		eclipseBug.setResolvedDate(new Timestamp(lastChangeTime));
		eclipseBug.setSummary((String)bug.get("summary"));
		eclipseBug.setAssignee((String)bug.get("assigned_to"));
		eclipseBug.save();
	}

	private void setupProperties() {
		try {
			properties = new Properties(System.getProperties());
			properties.load(new FileInputStream(PROPERTIES_FILE));
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
}