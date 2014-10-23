package com.evertonmaldonado.xtractor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

import com.evertonmaldonado.model.CommentFile;

public class GitPickaxeExtractor {

	private static final String BASH_SCRIPTS = "bash_scripts/";
	private static final String BASE_DIRECTORY = "/home/apple/git/";

	public String getLog(CommentFile commentFile, Collection<String> hackWords) {
		StringBuilder result = new StringBuilder();
		String fileName = commentFile.getFileName();
		String directory = commentFile.getDirectory();

		for(String hackWord : hackWords){
			//this is a work around
			try{
				if(hackWord.equals("temporary solution")){
					result.append(executeCommandWorkArround("git_pickaxe_temporary_solution.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else if(hackWord.equals("take care")){
					result.append(executeCommandWorkArround("git_pickaxe_take_care.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else if(hackWord.equals("workaround for bug")){
					result.append(executeCommandWorkArround("git_pickaxe_workaround_for_bug.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else if(hackWord.equals("is problematic")){
					result.append(executeCommandWorkArround("git_pickaxe_is_problematic.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else if(hackWord.equals("bail out")){
					result.append(executeCommandWorkArround("git_pickaxe_bail_out.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else if(hackWord.equals("don't use this")){
					result.append(executeCommandWorkArround("git_pickaxe_dont_use_thi.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else if(hackWord.equals("may cause problem")){
					result.append(executeCommandWorkArround("git_pickaxe_may_cause_problem.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else if(hackWord.equals("this is wrong")){
					result.append(executeCommandWorkArround("git_pickaxe_this_is_wrong.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else if(hackWord.equals("get rid of this ")){
					result.append(executeCommandWorkArround("git_pickaxe_get_rid_of_this.sh", fileName, directory));
					result.append(System.getProperty("line.separator"));
				}else{
					//can be improved
					result.append(executeCommand(hackWord.trim(), commentFile.getFileName(), commentFile.getDirectory()));
					if(result.equals("")){
						result.append(executeCommand(hackWord.toUpperCase().trim(), commentFile.getFileName(), commentFile.getDirectory()));
					}
				}
				return result.toString();
			}catch(Exception e){
				System.out.println(e.getMessage());
				return "There was an error getting the commit information";
			}
		}
		return "No hack word was passed";
	}

	private String executeCommand(String hackPattern, String className, String directory) throws ExecuteException, IOException{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		CommandLine command = new CommandLine("git"); 
		command.addArgument("log");
		command.addArgument("-S");
		command.addArgument("\""+hackPattern+"\"");
		command.addArgument("\""+className+"\"");

		DefaultExecutor executor = new DefaultExecutor();
		executor.setWorkingDirectory(new File(BASE_DIRECTORY+directory));
		executor.setStreamHandler(streamHandler);
		executor.execute(command);
//		return 
		String output = outputStream.toString();
		if(output.contains("This commit was manufactured"))
			return output.substring(0, 150) + "continues";
		else 
			return output;
	}

	private String executeCommandWorkArround(String scriptName,  String className, String directory) throws ExecuteException, IOException{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		CommandLine command = new CommandLine("/bin/sh"); 
		command.addArgument(BASH_SCRIPTS + scriptName);
		command.addArgument("\""+BASE_DIRECTORY+directory+"\"");
		command.addArgument("\""+className+"\"");
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		executor.execute(command);
		return outputStream.toString();
	}
} 