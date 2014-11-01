package com.evermal.execution;

import java.util.List;

import com.evermal.model.EclipseBug;
import com.evermal.model.LuceneBug;

public class DBBasedProjectAnalyzer {
	
	public static void  main(String args[]){
		
		List<EclipseBug> bugList = new EclipseBug().findAll();
		for (EclipseBug eclipseBug : bugList) {
//			System.out.print(eclipseBug.getCreationDate());
//			System.out.print("\t");
//			System.out.print(eclipseBug.getCommitedDate());
//			System.out.print("\t");
//			System.out.print(eclipseBug.getResolvedDate());
//			System.out.print("\t");
			System.out.println(eclipseBug.calculateDeltasOfBugLifesCycle());
		}
		
//		List<LuceneBug> bugList2 = new LuceneBug().findAll();
//		for (LuceneBug luceneBug : bugList2) {
//			System.out.print(luceneBug.getCreationDate());
//			System.out.print("\t");
//			System.out.print(luceneBug.getCommitedDate());
//			System.out.print("\t");
//			System.out.print(luceneBug.getResolvedDate());
//			System.out.print("\t");
//			System.out.println(luceneBug.calculateDeltasOfBugLifesCycle());
//		}
	}	
}