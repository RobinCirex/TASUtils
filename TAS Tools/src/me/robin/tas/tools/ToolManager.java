package me.robin.tas.tools;

import java.util.ArrayList;

public class ToolManager {

	private ArrayList<Tool> tools = new ArrayList<Tool>();

	public ToolManager() {
		registerTool(new Offsetter());
	}
	
	private void registerTool(Tool tool) {
		tools.add(tool);
	}
	
	public ArrayList<Tool> getTools() {
		return tools;
	}

}
