package com.evertonmaldonado.xtractor;

import java.util.HashSet;

public class MaintenanceClassifierWordMatcher {
	
	public void readCommits(){
		
	}


	private HashSet<String> loadCorrectiveWords(){
		HashSet<String> words = new HashSet<String>();
		words.add("bug");
		words.add("fixes");
		words.add("bugfix");
		words.add("correction");
		words.add("merge");
		return words;
	}
	
	private HashSet<String> loadAdaptativeWords(){
		HashSet<String> words = new HashSet<String>();
		words.add("java-doc");
		words.add("zoneinfo");
		words.add("translation");
		words.add("build");
		words.add("docs");
		return words;
	}
	
	private HashSet<String> loadPerfectiveWords(){
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
	
	private HashSet<String> loadFeatureAdditionWords(){
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
	
	private HashSet<String> loadNonFunctionalWords(){
		HashSet<String> words = new HashSet<String>();
		words.add("header");
		words.add("license");
		words.add("update");
		words.add("copyright");
		return words;
	}
}