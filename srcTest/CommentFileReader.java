import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.evertonmaldonado.model.CommentFile;
import com.evertonmaldonado.xtractor.HackWordMatcher;


public class CommentFileReader {

	@Test
	public void testCommentFileReader() throws Exception {

		FileInputStream fileStream = new FileInputStream("eclipse_all_comments.txt");
//		FileInputStream fileStream = new FileInputStream("small.txt");
		String file = IOUtils.toString(fileStream);
		String[] splited = file.split("<EndOfFile>");

		for (String commentsInOneClass : splited) {
			HackWordMatcher reader = new HackWordMatcher();
			reader.readComments(new CommentFile(commentsInOneClass));
		}
	}
}