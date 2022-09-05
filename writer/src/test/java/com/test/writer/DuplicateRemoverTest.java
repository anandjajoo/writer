package com.test.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.test.util.WriterUtils;
import com.writer.impl.DuplicateRemover;
import com.writer.impl.FileWriterImpl;
import com.writer.impl.IWriterInterface;
import com.writer.impl.StringWriterImpl;

public class DuplicateRemoverTest {
  
	 private String data = "This is duplicate duplicate remover";
	 private String dataAfterConversion = "This is duplicate remover";
	
	
    @Test
    public void duplicateRemoverString() throws IOException {
    	IWriterInterface writerInterface  = new DuplicateRemover(new StringWriterImpl());
    	writerInterface.write(data);
        assertTrue(dataAfterConversion.equals(writerInterface.toString()));
    }

    @Test
    public void duplicateRemoverFile() throws IOException {
    	IWriterInterface writerInterface = new DuplicateRemover(new FileWriterImpl(WriterUtils.FILE_NAME));
    	writerInterface.write(data);
        assertTrue(dataAfterConversion.equals(WriterUtils.readFile()));
    }

    @Test
    public void duplicateRemoverStringClose() throws IOException{
    	IWriterInterface writerInterface = new DuplicateRemover(new StringWriterImpl());
    	writerInterface.write(data);
    	writerInterface.close();
    	writerInterface.write("duplicate remover");
        assertEquals(dataAfterConversion, writerInterface.toString());
    }
    
    
}
