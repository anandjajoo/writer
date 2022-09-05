package com.writer.impl;

import java.io.IOException;

public class StupidRemover extends DecoratorWriter {

	public StupidRemover(IWriterInterface writerInterface) {
		writer = writerInterface;
	}

	public String removeStupid(String string) {
		return string.replaceAll("stupid", "s*****");
	}

	@Override
	public void write(String content) throws IOException {
		String data = removeStupid(content);
		writer.write(removeStupid(data));
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