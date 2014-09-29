package com.evertonmaldonado.xtractor;

import java.io.IOException;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;

import com.evertonmaldonado.model.Commit;
import com.evertonmaldonado.model.CommitFile;
import com.evertonmaldonado.model.FileCounter;

public class MaintenanceClassifierWordMatcher {
	
	public void readCommits(CommitFile commitFile) throws IOException{
		boolean hasCorrective = checkCommitMessageWith(correctiveWords(), commitFile, "outputFiles/corrective_change.txt");
		boolean hasAdaptative = checkCommitMessageWith(adaptativeWords(), commitFile, "outputFiles/adaptative_change.txt");
		boolean hasPerfective = checkCommitMessageWith(perfectiveWords(), commitFile, "outputFiles/perfective_change.txt");
		boolean hasFeatureAddition = checkCommitMessageWith(featureAdditionWords(), commitFile, "outputFiles/feature_addition_change.txt");
		boolean hasNonFunctional = checkCommitMessageWith(nonFunctionalWords(), commitFile, "outputFiles/feature_addition_change.txt");
		
		checkCommitMessageWith(hackWords(), commitFile, "outputFiles/hack_commit_message.txt");

		if(hasCorrective)
			FileCounter.incrementCorrectiveChange();
		if(hasAdaptative)
			FileCounter.incrementAdaptativeChange();
		if(hasPerfective)
			FileCounter.incrementPerfectiveChange();
		if(hasFeatureAddition)
			FileCounter.incrementFeatureAdditionChange();
		if(hasNonFunctional)	
			FileCounter.incrementNonFunctionalChange();
		if(!hasCorrective && !hasAdaptative && !hasPerfective && !hasFeatureAddition && !hasNonFunctional){
			FileCounter.incrementWithoutClassificationChange();
		}
	}

	private boolean checkCommitMessageWith(HashSet<String> words, CommitFile commitFile, String outputFileName) throws IOException {
		boolean hasClassification = false;
		for(Commit commit : commitFile.getCommits()){
			for (String word : words) {
				if(commit.getCommitMessage().toLowerCase().contains(word)){
					StringBuilder sb = new StringBuilder();
					sb.append(commitFile.getAbsoluteFileName());
					sb.append(System.getProperty("line.separator"));
					sb.append("Commit message contains the word:");
					sb.append(word);
					sb.append(System.getProperty("line.separator"));
					sb.append("Commit information:");
					sb.append(commit.getId());
					sb.append(System.getProperty("line.separator"));
					sb.append(commit.getAuthor());
					sb.append(System.getProperty("line.separator"));
					sb.append(commit.getCommitMessage());
					sb.append(System.getProperty("line.separator"));
					FileUtils.write(FileUtils.getFile(outputFileName), sb.toString(), true);
					hasClassification = true;
					break;
				}
			}
		}
		return hasClassification;
	}

	private HashSet<String> correctiveWords(){
		HashSet<String> words = new HashSet<String>();
		words.add("bug");
		words.add("fixes");
		words.add("bugfix");
		words.add("correction");
		words.add("merge");
		return words;
	}
	
	private HashSet<String> adaptativeWords(){
		HashSet<String> words = new HashSet<String>();
		words.add("java-doc");
		words.add("zoneinfo");
		words.add("translation");
		words.add("build");
		words.add("docs");
		return words;
	}
	
	private HashSet<String> perfectiveWords(){
		HashSet<String> words = new HashSet<String>();
		words.add("package");
		words.add("reorganized");
		words.add("nuke");
		words.add("major");
		words.add("refactoring");
		words.add("cleanup");
		words.add("removed");
		words.add("moved");
		words.add("directory");
		return words;
	}
	
	private HashSet<String> featureAdditionWords(){
		HashSet<String> words = new HashSet<String>();
		words.add("initial");
		words.add("spirit");
		words.add("version");
		words.add("checkin");
		words.add("merged");
		words.add("create");
		words.add("revision");
		words.add("types");
		return words;
	}
	
	private HashSet<String> nonFunctionalWords(){
		HashSet<String> words = new HashSet<String>();
		words.add("header");
		words.add("license");
		words.add("update");
		words.add("copyright");
		return words;
	}
	
	private HashSet<String> hackWords() {
		HashSet<String> words = new HashSet<String>();
		words.add("hack");
		words.add("retarded");
		words.add("at a loss");
		words.add("stupid");
		words.add("remove this code");
		words.add("ugly");
		words.add("take care");
		words.add("something's gone wrong");
		words.add("nuke");
		words.add("is problematic");
		words.add("may cause problem");
		words.add("hacky");
		words.add("unknown why we ever experience this");
		words.add("treat this as a soft error");
		words.add("silly");
		words.add("workaround for bug");
		words.add("kludge");
		words.add("fixme");
		words.add("this isn't quite right");
		words.add("trial and error");
		words.add("give up");
		words.add("this is wrong");
		words.add("hang our heads in shame");
		words.add("temporary solution");
		words.add("causes issue");
		words.add("something bad is going on");
		words.add("cause for issue");
		words.add("this doesn't look right");
		words.add("is this next line safe");
		words.add("this indicates a more fundamental problem");
		words.add("temporary crutch");
		words.add("this can be a mess");
		words.add("this isn't very solid");
		words.add("this is temporary and will go away");
		words.add("is this line really safe");
//		words.add("there is a problem"); removed to analyze eclipse projects
		words.add("some fatal error");
		words.add("something serious is wrong");
		words.add("don't use this");
		words.add("get rid of this");
		words.add("doubt that this would work");
		words.add("this is bs");
		words.add("give up and go away");
		words.add("risk of this blowing up");
		words.add("just abandon it");
		words.add("prolly a bug");
		words.add("probably a bug");
		words.add("hope everything will work");
		words.add("toss it");
//		words.add("barf"); removed to analyze eclipse projects
		words.add("something bad happened");
		words.add("fix this crap");
		words.add("yuck");
		words.add("certainly buggy");
		words.add("remove me before production");
		words.add("you can be unhappy now");
		words.add("this is uncool");
		words.add("bail out");
		words.add("it doesn't work yet");
		words.add("crap");
		words.add("inconsistency");
		words.add("abandon all hope");
		words.add("kaboom");
		return words;
	}
}