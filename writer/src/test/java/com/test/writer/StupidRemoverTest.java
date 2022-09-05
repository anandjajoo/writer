package com.test.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.test.util.WriterUtils;
import com.writer.impl.FileWriterImpl;
import com.writer.impl.IWriterInterface;
import com.writer.impl.StringWriterImpl;
import com.writer.impl.StupidRemover;

public class StupidRemoverTest {
  
	 private String data = "This is stupid remover";
	 private String dataAfterConversion = "This is s***** remover";
	
	
    @Test
    public void stupidRemoverString() throws IOException {
    	IWriterInterface writerInterface = new StupidRemover(new StringWriterImpl());
    	writerInterface.write(data);
        assertTrue(dataAfterConversion.equals(writerInterface.toString()));
    }

    @Test
    public void stupidRemoverFile() throws IOException {
    	IWriterInterface writerInterface = new StupidRemover(new FileWriterImpl(WriterUtils.FILE_NAME));
    	writerInterface.write(data);
        assertTrue(dataAfterConversion.equals(WriterUtils.readFile()));
    }

    @Test
    public void duplicateRemoverStringClose() throws IOException{
    	IWriterInterface writerInterface = new StupidRemover(new StringWriterImpl());
    	writerInterface.write(data);
    	writerInterface.close();
    	writerInterface.write("stupid remover");
        assertEquals(dataAfterConversion, writerInterface.toString());
    }
    
    
    
    
}
