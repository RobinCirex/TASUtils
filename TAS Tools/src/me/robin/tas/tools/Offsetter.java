package me.robin.tas.tools;

import java.util.ArrayList;

public class Offsetter extends Tool {

	public Offsetter() {
		super("offset");
	}

	@Override
	public void runTool(String[] args) {

		String path = args[1];

		int startFrame = Integer.parseInt(args[2]);
		int frameOffset = Integer.parseInt(args[3]);

		ArrayList<String> lines = FileUtil.readFile(path);
		ArrayList<String> newLines = new ArrayList<String>();

		for (String line : lines) {
			
			if (line.isEmpty())
				continue;
			int frameNumber = Integer.parseInt(line.split(" ")[0]);
			if (frameNumber < startFrame) {
				newLines.add(line);
			} else {
				String newLine = (frameNumber + frameOffset) + line.substring(line.split(" ")[0].length());
				newLines.add(newLine);
				System.out.println(newLine);
			}
		}

		FileUtil.clear(path);
		FileUtil.write(path, newLines);

		super.runTool(args);
	}

}
