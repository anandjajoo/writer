package com.writer.impl;

import java.io.IOException;
import java.util.StringTokenizer;

public class DuplicateRemover extends DecoratorWriter {
	
	private static final String SPACE = " ";
	
	public DuplicateRemover(IWriterInterface writerInterface) {
		writer = writerInterface;
	}

	@Override
	public void write(String content) throws IOException {
		String data = removeDuplicatesFromInput(content);
		writer.write(data);
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

	
	@Override
	public String toString() {
		return writer.toString();
	}
	 
   
	public String removeDuplicatesFromInput(String data) {
		String current = "";
		StringBuilder dataBuilder = new StringBuilder();
		StringTokenizer tokens = new StringTokenizer(data);
		
		while(tokens.hasMoreElements()) {
			String next = tokens.nextToken();
			if (!current.equals(next)) {
				dataBuilder.append(next + SPACE);
				current = next;
			}
		}
		return dataBuilder.toString().trim();
	}
}
