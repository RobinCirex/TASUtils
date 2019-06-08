package me.robin.tas.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtil {

	public static ArrayList<String> readFile(String path) {
		ArrayList<String> file = new ArrayList<String>();

		try {

			Scanner sc = new Scanner(new File(path));

			while (sc.hasNextLine()) {
				file.add(sc.nextLine());				
			}

			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return file;
	}

	public static void write(String path, String... lines) {
		ArrayList<String> toWrite = new ArrayList<String>();
		for (String s : lines) {
			toWrite.add(s);
		}
		write(path, toWrite);

	}

	public static void write(String path, ArrayList<String> lines) {
		try {
			FileWriter fw = new FileWriter(new File(path));

			for (String string : lines) {
				fw.write(string + '\n');
				fw.flush();
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void removeLine(String path, int lineNumber) {
		ArrayList<String> file = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));

			int lineCount = 0;
			String line;

			while ((line = br.readLine()) != null) {
				if (lineCount != lineNumber)
					file.add(line);
				lineCount++;
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void removeLine(String path, String lineToRemove) {
		ArrayList<String> file = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));

			String line;

			while ((line = br.readLine()) != null) {
				if (!lineToRemove.equalsIgnoreCase(line))
					file.add(line);
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void clear(String path) {
		try {
			PrintWriter pw = new PrintWriter(path);
			pw.write("");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
