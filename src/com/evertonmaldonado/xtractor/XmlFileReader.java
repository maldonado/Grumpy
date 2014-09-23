package com.evertonmaldonado.xtractor;

import org.apache.commons.io.FileUtils;

import com.evertonmaldonado.model.Unit;
import com.thoughtworks.xstream.XStream;

public class XmlFileReader {
	
	public void readXML(String sourceFile) throws Exception{
		
		XStream stream = new XStream();
		stream.alias("unit", Unit.class);
		stream.registerConverter(new Src2SrmlConverter());
		
		Unit unit = (Unit) stream.fromXML(sourceFile);
		
		if(!unit.getComment().isEmpty()){
			StringBuilder b = new StringBuilder();
			b.append(System.getProperty("line.separator"));
			b.append(unit.getFileName());
			b.append(System.getProperty("line.separator"));
			b.append("<BeginOfFile>");
			for (String comment : unit.getComment()) {
				b.append(comment);
				b.append(System.getProperty("line.separator"));
			}
			b.append(System.getProperty("line.separator"));
			b.append("<EndOfFile>");
			b.append(System.getProperty("line.separator"));
			
			FileUtils.writeStringToFile(FileUtils.getFile("eclipse_all_comments.txt"), b.toString(), true);
		}
	}
}