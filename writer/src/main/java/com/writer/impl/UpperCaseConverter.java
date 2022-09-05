package com.writer.impl;

import java.io.IOException;

public class UpperCaseConverter extends DecoratorWriter {

	public String convertToUpperCase(String data) {
		return data.toUpperCase();
	}

	public UpperCaseConverter(IWriterInterface writerInterface) {
		writer = writerInterface;
	}

	@Override
	public void write(String content) throws IOException {
		String data  = convertToUpperCase(content);
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
	 
}
