package com.writer.impl;

import java.io.IOException;

public class LowerCaseConverter extends DecoratorWriter {

    public LowerCaseConverter(IWriterInterface writerInterface){
        writer = writerInterface;
    }

    public String convertToLowerCase(String data){
        return data.toLowerCase();
    }

    @Override
    public void write(String content) throws IOException {
    	String data = convertToLowerCase(content);
        writer.write(data);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    @Override
    public String toString(){
        return writer.toString();
    }
}
