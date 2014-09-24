import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.IOUtils;

import com.evertonmaldonado.xtractor.XmlFileReader;


public class Executor {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fileStream = new FileInputStream("eclipse_jdt01.xml");
		try {
			Collection<String> nodes = new ArrayList<String>();
			String file = IOUtils.toString(fileStream);
			String[] splited = file.split("</unit>");
			
			for (String node : splited) {
//				System.out.println(node);
				
				if(node.contains("<unit ")){
					StringBuilder b = new StringBuilder();
					b.append(node+"</unit>");
					nodes.add(b.toString());
				}
			}
			
			for (String parcialNode : nodes) {
				XmlFileReader reader = new XmlFileReader();
				reader.readXML(parcialNode);
				
			}
						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
