package com.writer.impl;
import java.io.IOException;

public interface IWriterInterface{
	void write(String data) throws IOException;
    void close() throws IOException;
}

