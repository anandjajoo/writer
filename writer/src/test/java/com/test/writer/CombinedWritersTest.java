package com.test.writer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.test.util.WriterUtils;
import com.writer.impl.DuplicateRemover;
import com.writer.impl.FileWriterImpl;
import com.writer.impl.IWriterInterface;
import com.writer.impl.LowerCaseConverter;
import com.writer.impl.StringWriterImpl;
import com.writer.impl.StupidRemover;
import com.writer.impl.UpperCaseConverter;


public class CombinedWritersTest {
	

    @Test
    public void lowerCaseRemoverOnStupidRemover() throws IOException {
        IWriterInterface writerInterface = new LowerCaseConverter(new StringWriterImpl());
        writerInterface = new StupidRemover(writerInterface);
        writerInterface.write("This is ReaLLy stupid");
        assertEquals("this is really s*****", writerInterface.toString());
    }

    @Test
    public void upperCaseRemoverOnStupidRemover() throws IOException {
    	IWriterInterface writerInterface = new UpperCaseConverter(new StringWriterImpl());
    	writerInterface = new StupidRemover(writerInterface);
    	writerInterface.write("This is ReaLLy stupid");
        assertEquals("THIS IS REALLY S*****", writerInterface.toString());
    }

	@Test
	public void stupidRemoverOnLowerWithFileWriter() throws IOException {
		IWriterInterface writerInterface= new LowerCaseConverter( new FileWriterImpl(WriterUtils.FILE_NAME));
		writerInterface = new StupidRemover(writerInterface);
		writerInterface = new DuplicateRemover(writerInterface);
		writerInterface.write("HELLO stupid stupid    WORLD");
		assertEquals("hello s***** world", WriterUtils.readFile());
	}
	 

    @Test
    public void stupidRemoverOnUpper() throws IOException {
    	IWriterInterface writerInterface = new StringWriterImpl();
    	writerInterface = new UpperCaseConverter(writerInterface);
    	writerInterface = new StupidRemover(writerInterface);
    	writerInterface = new DuplicateRemover(writerInterface);
    	writerInterface.write("This is really stupid");
        assertEquals("THIS IS REALLY S*****", writerInterface.toString());
    }
    
    @Test
	public void stupidRemoverOnLowerOnDuplicateWithFileWriter() throws IOException {
    	IWriterInterface writerInterface  = new DuplicateRemover(new FileWriterImpl(WriterUtils.FILE_NAME));
    	writerInterface = new LowerCaseConverter(writerInterface);
    	writerInterface = new StupidRemover(writerInterface);
    	writerInterface = new DuplicateRemover(writerInterface);
    	writerInterface.write("HELLO stupid stupid    WORLD");
		assertEquals("hello s***** world", WriterUtils.readFile());
	}
    
    @Test
	public void stupidRemoverOnLowerWithFileWriterClose() throws IOException {
    	IWriterInterface writerInterface = new DuplicateRemover(new FileWriterImpl(WriterUtils.FILE_NAME));
    	writerInterface = new LowerCaseConverter(writerInterface);
    	writerInterface = new StupidRemover(writerInterface);
    	writerInterface = new DuplicateRemover(writerInterface);
    	writerInterface.write("HELLO stupid stupid WORLD");
    	writerInterface.close();
    	writerInterface.write("stupidRemoverOnLowerWithFileWriterClose after close call");
		assertEquals("hello s***** world", WriterUtils.readFile());
	}
    
    
}
