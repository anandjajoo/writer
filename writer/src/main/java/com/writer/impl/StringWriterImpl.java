package com.writer.impl;

public class StringWriterImpl implements IWriterInterface {
	private StringBuilder data = new StringBuilder();
	private boolean isClosed;

	public void write(String inputData) {
		if (!isClosed) {
			data = data.append(inputData);
		}
	}

	public String toString() {
		return data.toString();
	}

	public void close() {
		isClosed = true;
	}
}