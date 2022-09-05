package com.test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WriterUtils {
	
	public static final String FILE_NAME = "myfile.dat";
	
	public static String readFile() throws IOException {
		StringBuilder sb = new StringBuilder();
		File file = new File(FILE_NAME);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null)
				sb.append(new String(line));
		}
		return sb.toString();
	}

}
