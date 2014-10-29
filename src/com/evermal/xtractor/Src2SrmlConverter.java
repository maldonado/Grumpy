package com.evermal.xtractor;

import com.evermal.model.Unit;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


public class Src2SrmlConverter implements Converter{
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class clazz){
		return clazz.equals(Unit.class);
	}
	
	@Override
	public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context){
		
	}
	
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context){
		
		Unit unit  = new Unit();
		String fileName = reader.getAttribute("filename");
		unit.setFileName(fileName);	
		
		while(reader.hasMoreChildren()){
			reader.moveDown();
			if("comment".equals(reader.getNodeName())){
				String comment = reader.getValue();
				unit.addComment(comment);
			}
			if("class".equals(reader.getNodeName())){
				while(reader.hasMoreChildren()){
					reader.moveDown();
					if("comment".equals(reader.getNodeName())){
						String comment = reader.getValue();
						unit.addComment(comment);
					}
					if("block".equals(reader.getNodeName())){
						while(reader.hasMoreChildren()){
							reader.moveDown();
							if("comment".equals(reader.getNodeName())){
								String comment = reader.getValue();
								unit.addComment(comment);
							}
							reader.moveUp();
						}
					}
					reader.moveUp();
				}
			}
			reader.moveUp();
		}
		return unit;
	}
}