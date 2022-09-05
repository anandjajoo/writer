package com.test.writer;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.test.util.WriterUtils;
import com.writer.impl.FileWriterImpl;
import com.writer.impl.IWriterInterface;
import com.writer.impl.StringWriterImpl;
import com.writer.impl.UpperCaseConverter;

public class UpperCaseConverterTest {
	
	
	private String data = "Upper Case Check";
	private String dataAfterConversion = "UPPER CASE CHECK";
	
    @Test
    public void upperCaseConverterCheckString() throws IOException {
    	IWriterInterface writerInterface = new UpperCaseConverter(new StringWriterImpl());
    	writerInterface.write(data);
        assertEquals(dataAfterConversion, writerInterface.toString());
    }
    
    @Test
    public void upperCaseConverterCheckFile() throws IOException {
    	IWriterInterface writerInterface = new UpperCaseConverter(new FileWriterImpl(WriterUtils.FILE_NAME));
    	writerInterface.write(data);
        assertEquals(dataAfterConversion, WriterUtils.readFile());
    }
    
    @Test
    public void upperCaseConverterCheckStringCLose() throws IOException{
    	IWriterInterface writerInterface  = new UpperCaseConverter(new StringWriterImpl());
    	writerInterface.write(data);
    	writerInterface.close();
    	writerInterface.write("write after close");
    	writerInterface.write("write after close call");
        assertEquals(dataAfterConversion, writerInterface.toString());
    }

  
  

}
