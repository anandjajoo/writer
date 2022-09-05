package com.test.writer;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.test.util.WriterUtils;
import com.writer.impl.FileWriterImpl;
import com.writer.impl.IWriterInterface;
import com.writer.impl.LowerCaseConverter;
import com.writer.impl.StringWriterImpl;

public class LowerCaseConverterTest {
	
	
	private String data = "LOWER CASE CHECK";
	private String dataAfterConversion = "lower case check";
	
    @Test
    public void lowerCaseConverterCheckString() throws IOException {
    	IWriterInterface writerInterface = new LowerCaseConverter(new StringWriterImpl());
    	writerInterface.write(data);
        assertEquals(dataAfterConversion, writerInterface.toString());
    }
    
    @Test
    public void lowerCaseConverterCheckFile() throws IOException {
    	IWriterInterface writerInterface  = new LowerCaseConverter(new FileWriterImpl(WriterUtils.FILE_NAME));
    	writerInterface.write(data);
        assertEquals(dataAfterConversion, WriterUtils.readFile());
    }
    
    @Test
    public void lowerCaseConverterCheckStringCLose() throws IOException{
    	IWriterInterface writerInterface = new LowerCaseConverter(new StringWriterImpl());
    	writerInterface.write(data);
    	writerInterface.close();
    	writerInterface.write("write after close");
    	writerInterface.write("write after close call");
        assertEquals(dataAfterConversion, writerInterface.toString());
    }

  
  

}
