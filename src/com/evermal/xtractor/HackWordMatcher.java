package com.evermal.xtractor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.commons.io.IOUtils;

import com.evermal.model.CommentFile;

public class HackWordMatcher {

	private HashSet<String> wordList;

	public HackWordMatcher(){
		wordList =  loadWords();
	}
	
	public String proccess(String fileName) throws IOException{
		FileInputStream fileStream = new FileInputStream(fileName);
		String file = IOUtils.toString(fileStream);
		String[] splited = file.split("<EndOfFile>");
		StringBuilder sb = new StringBuilder();
		for (String commentsInOneClass : splited) {
			try {
				CommentFile commentFile = new CommentFile(commentsInOneClass);
				sb.append(readComments(commentFile));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return sb.toString();
	}

	private String readComments(CommentFile commentFile) throws IOException{
		if(commentFile.getAbsoluteFileName() == null)
			return "";

		ArrayList<String> occurrences = new ArrayList<String>();
		for (String word : wordList) {
			if(commentFile.getContent().toLowerCase().contains(word.toLowerCase())){
				occurrences.add(word);
			}
		}
		StringBuilder sb  = new StringBuilder();
		if(!occurrences.isEmpty()){
			sb.append(System.getProperty("line.separator"));
			sb.append(commentFile.getAbsoluteFileName());
			sb.append(System.getProperty("line.separator"));
			sb.append("<BeginOfFile>");
			sb.append(System.getProperty("line.separator"));
			sb.append("has " + occurrences.size() + " hack patterns :");
			for(String occurrence : occurrences){
				sb.append(System.getProperty("line.separator"));
				sb.append(occurrence + " ; ");
				sb.append(System.getProperty("line.separator"));
			}
			try{
				sb.append("<BeginOfCommit>");
				sb.append(System.getProperty("line.separator"));
				sb.append(new GitPickaxeExtractor().getLog(commentFile, occurrences));
				sb.append(System.getProperty("line.separator"));
				sb.append("<EndOfCommit>");
			}catch(Exception e){
				System.out.println(commentFile.getAbsoluteFileName() + "  " +  e.getMessage());
				sb.append(System.getProperty("line.separator"));
				sb.append("<EndOfCommit>");
			}
			sb.append(System.getProperty("line.separator"));
			sb.append("<EndOfFile>");
		}
		return sb.toString();
	}

	private HashSet<String> loadWords() {
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
		//remove when analyzing eclipse
//		words.add("there is a problem");
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
		//remove when analyzing eclipse
//		words.add("barf"); 
		words.add("something bad happened");
		words.add("fix this crap");
		words.add("yuck");
		words.add("certainly buggy");
		words.add("remove me before production");
		words.add("you can be unhappy now");
		words.add("this is uncool");
		words.add("bail out");
		words.add("it doesn't work yet");
		words.add(" crap ");
		words.add("inconsistency");
		words.add("abandon all hope");
		words.add("kaboom");
		return words;
	}
}