import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.evermal.model.CommentFile;
import com.evermal.model.FileCounter;
import com.evermal.xtractor.HackWordMatcher;


public class CommentFileReader {

	@Test
	public void testCommentFileReader() throws Exception {

		FileInputStream fileStream = new FileInputStream("ExtractedComments/freechart-fse_comments.txt");
		String file = IOUtils.toString(fileStream);
		String[] splited = file.split("<EndOfFile>");

		for (String commentsInOneClass : splited) {
			HackWordMatcher reader = new HackWordMatcher();
//			reader.readComments(new CommentFile(commentsInOneClass));
		}
		System.out.println("numberOfFilesAnalyzed =  "+ FileCounter.getNumberOfFilesAnalyzed());
	}
}