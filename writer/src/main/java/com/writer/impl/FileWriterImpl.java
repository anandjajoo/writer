package com.writer.impl;

import java.io.FileWriter;
import java.io.IOException;


public class FileWriterImpl implements IWriterInterface {

   private FileWriter fileWriter;
   private boolean isClosed;

    public FileWriterImpl(String file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    @Override
    public void write(String string) throws IOException {
        if (!isClosed){
            fileWriter.write(string);
            fileWriter.flush();
        }
    }

    @Override
	public void close() {
    	isClosed = true;
	}
    
  

}
