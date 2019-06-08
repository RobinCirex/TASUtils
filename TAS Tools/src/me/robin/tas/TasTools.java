package me.robin.tas;

import me.robin.tas.tools.FileUtil;
import me.robin.tas.tools.Tool;
import me.robin.tas.tools.ToolManager;

public class TasTools {
	
	
	private static ToolManager toolManager = new ToolManager();
	
	
	public static void main(String[] args) {
		String toolName = args[0];
		String path = args[1];
		
		for(Tool tool : toolManager.getTools()) {
			if(tool.getName().equalsIgnoreCase(toolName)) {
				tool.runTool(args);
			}
		}
	
	}

}
