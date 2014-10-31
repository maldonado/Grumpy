import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.evermal.model.CommentFile;
import com.evermal.model.CommitFile;
import com.evermal.model.FileCounter;
import com.evermal.xtractor.HackWordMatcher;
import com.evermal.xtractor.MaintenanceClassifierWordMatcher;


public class CommitStarter {

	@Test
	public void start() throws IOException{
		FileInputStream fileStream = new FileInputStream("HackwordAndCommit/jmeter_hack_pattern.txt");
		String file = IOUtils.toString(fileStream);
		String[] splited = file.split("<EndOfFile>");

		for (String commentsInOneClass : splited) {
			MaintenanceClassifierWordMatcher reader = new MaintenanceClassifierWordMatcher();
//			CommitFile commitFile = new CommitFile(commentsInOneClass);
//			reader.readCommits(commitFile);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("numberOfFilesAnalyzed =  "+ FileCounter.getNumberOfFilesAnalyzed());
		sb.append(System.getProperty("line.separator"));
		sb.append("numberOfCommitMessagesAnalyzed =  "+ FileCounter.getNumberOfCommitMessagesAnalyzed());
		sb.append(System.getProperty("line.separator"));
		sb.append("correctiveChange =  "+ FileCounter.getCorrectiveChange());
		sb.append(System.getProperty("line.separator"));
		sb.append("adaptativeChange =  "+ FileCounter.getAdaptativeChange());
		sb.append(System.getProperty("line.separator"));
		sb.append("perfectiveChange =  "+ FileCounter.getPerfectiveChange());
		sb.append(System.getProperty("line.separator"));
		sb.append("featureAdditionChange =  "+ FileCounter.getFeatureAdditionChange());
		sb.append(System.getProperty("line.separator"));
		sb.append("nonFunctionalChange =  "+ FileCounter.getNonFunctionalChange());
		sb.append(System.getProperty("line.separator"));
		sb.append("withoutClassificationChange =  "+ FileCounter.getWithoutClassificationChange());
		FileUtils.write(FileUtils.getFile("jmeter_hack_pattern.txt"), sb, true);
	}
}