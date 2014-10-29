import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.evermal.xtractor.XmlFileReader;

public class XmlFileReaderTest {

	@Test
	public void testXMLReader() throws Exception {
		
		FileInputStream fileStream = new FileInputStream("ParsedCode/freechart-fse.xml");
		try {
			Collection<String> nodes = new ArrayList<String>();
			String file = IOUtils.toString(fileStream);
			String[] splited = file.split("</unit>");
			
			for (String node : splited) {
				if(node.contains("<unit ")){
					StringBuilder b = new StringBuilder();
					b.append(node+"</unit>");
					nodes.add(b.toString());
				}
			}
			
			for (String parcialNode : nodes) {
				XmlFileReader reader = new XmlFileReader();
//				reader.readXML(parcialNode);
			}
						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}