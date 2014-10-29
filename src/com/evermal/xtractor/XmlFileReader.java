package com.evermal.xtractor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.IOUtils;

import com.evermal.model.Unit;
import com.thoughtworks.xstream.XStream;

public class XmlFileReader {

	public String readXML(String parsedFile) throws Exception{

		Collection<String> nodes = prepareNodes(parsedFile);
		return processNodes(nodes);
	}

	private String processNodes(Collection<String> nodes) {

		XStream stream = new XStream();
		stream.alias("unit", Unit.class);
		stream.registerConverter(new Src2SrmlConverter());
		StringBuilder sb = new StringBuilder();

		for (String node : nodes) {
			Unit unit = (Unit) stream.fromXML(node);

			if(!unit.getComment().isEmpty()){
				sb.append(System.getProperty("line.separator"));
				sb.append(unit.getFileName());
				sb.append(System.getProperty("line.separator"));
				sb.append("<BeginOfFile>");
				for (String comment : unit.getComment()) {
					sb.append(comment);
					sb.append(System.getProperty("line.separator"));
				}
				sb.append(System.getProperty("line.separator"));
				sb.append("<EndOfFile>");
				sb.append(System.getProperty("line.separator"));	
			}
		}
		return sb.toString();
	}

	private Collection<String> prepareNodes(String parsedFile) throws FileNotFoundException, IOException {
		FileInputStream fileStream = new FileInputStream(parsedFile);

		String file = IOUtils.toString(fileStream);
		String[] splited = file.split("</unit>");

		Collection<String> nodes = new ArrayList<String>();
		for (String node : splited) {
			if(node.contains("<unit ")){                               
				StringBuilder b = new StringBuilder();
				b.append(node+"</unit>");
				nodes.add(b.toString());
			}
		}
		return nodes;
	}
}