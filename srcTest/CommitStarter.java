import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.evertonmaldonado.model.CommentFile;
import com.evertonmaldonado.model.CommitFile;
import com.evertonmaldonado.model.FileCounter;
import com.evertonmaldonado.xtractor.HackWordMatcher;
import com.evertonmaldonado.xtractor.MaintenanceClassifierWordMatcher;


public class CommitStarter {

	@Test
	public void start() throws IOException{
		FileInputStream fileStream = new FileInputStream("eclipse_hack_pattern.txt");
//		FileInputStream fileStream = new FileInputStream("test.txt");
		String file = IOUtils.toString(fileStream);
		String[] splited = file.split("<EndOfFile>");

		for (String commentsInOneClass : splited) {
			MaintenanceClassifierWordMatcher reader = new MaintenanceClassifierWordMatcher();
			reader.readCommits(new CommitFile(commentsInOneClass));
		}
		System.out.println("numberOfFilesAnalyzed =  "+ FileCounter.getNumberOfFilesAnalyzed());
		System.out.println("numberOfCommitMessagesAnalyzed =  "+ FileCounter.getNumberOfCommitMessagesAnalyzed());
		System.out.println("correctiveChange =  "+ FileCounter.getCorrectiveChange());
		System.out.println("adaptativeChange =  "+ FileCounter.getAdaptativeChange());
		System.out.println("perfectiveChange =  "+ FileCounter.getPerfectiveChange());
		System.out.println("featureAdditionChange =  "+ FileCounter.getFeatureAdditionChange());
		System.out.println("nonFunctionalChange =  "+ FileCounter.getNonFunctionalChange());
		System.out.println("withoutClassificationChange =  "+ FileCounter.getWithoutClassificationChange());
	}

}
