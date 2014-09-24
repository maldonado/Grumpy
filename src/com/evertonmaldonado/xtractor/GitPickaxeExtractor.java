package com.evertonmaldonado.xtractor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

import com.evertonmaldonado.model.CommentFile;

public class GitPickaxeExtractor {

	private static final String BASH_SCRIPTS = "bash_scripts/";

	public String getLog(CommentFile commentFile, String hackPattern) throws ExecuteException, IOException{
		String result = null;
		String fileName = commentFile.getFileName();
		String directory = commentFile.getDirectory();
		
		if(hackPattern.equals("temporary solution")){
			return result = executeCommandWorkArround("git_pickaxe_temporary_solution.sh", fileName, directory);

		}else if(hackPattern.equals("take care")){
			return result = executeCommandWorkArround("git_pickaxe_take_care.sh", fileName, directory);

		}else if(hackPattern.equals("workaround for bug")){
			return result = executeCommandWorkArround("git_pickaxe_workaround_for_bug.sh", fileName, directory);

		}else if(hackPattern.equals("is problematic")){
			return result = executeCommandWorkArround("git_pickaxe_is_problematic.sh", fileName, directory);

		}else if(hackPattern.equals("bail out")){
			return result = executeCommandWorkArround("git_pickaxe_bail_out.sh", fileName, directory);

		}else if(hackPattern.equals("don't use this")){
			return result = executeCommandWorkArround("git_pickaxe_dont_use_thi.sh", fileName, directory);

		}else if(hackPattern.equals("may cause problem")){
			return result = executeCommandWorkArround("git_pickaxe_may_cause_problem.sh", fileName, directory);

		}else if(hackPattern.equals("this is wrong")){
			return result = executeCommandWorkArround("git_pickaxe_this_is_wrong.sh", fileName, directory);

		}else if(hackPattern.equals("get rid of this ")){
			return result = executeCommandWorkArround("git_pickaxe_get_rid_of_this.sh", fileName, directory);

		}else{
			result = executeCommand(hackPattern, commentFile.getFileName(), commentFile.getDirectory());
			if(result.equals("")){
				result = executeCommand(hackPattern.toUpperCase(), commentFile.getFileName(), commentFile.getDirectory());
			}
		}
		return result;
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
		executor.setWorkingDirectory(new File(directory));
		executor.setStreamHandler(streamHandler);
		executor.execute(command);
		return outputStream.toString();
	}
	
	private String executeCommandWorkArround(String scriptName,  String className, String directory) throws ExecuteException, IOException{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		CommandLine command = new CommandLine("/bin/sh"); 
		command.addArgument(BASH_SCRIPTS + scriptName);
		command.addArgument("\""+directory+"\"");
		command.addArgument("\""+className+"\"");
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		executor.execute(command);
		return outputStream.toString();
	}
} 