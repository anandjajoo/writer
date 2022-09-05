package com.writer.impl;

import java.io.IOException;

public class TestSample {
	
	public static void main(String[] args) throws IOException {
		 closeCall();
		 withoutCloseCall();
	}

	private static void closeCall() throws IOException {
		IWriterInterface stringWriter = new StringWriterImpl();
		 stringWriter = new LowerCaseConverter(stringWriter);
		 stringWriter = new StupidRemover(stringWriter);
		 stringWriter = new DuplicateRemover(stringWriter);
		 stringWriter.close();
		 stringWriter.write("HELLO STUPID STUPID WORLD");
	     System.out.println(stringWriter.toString());
	}
	
	private static void withoutCloseCall() throws IOException {
		IWriterInterface stringWriter = new StringWriterImpl();
		 stringWriter = new LowerCaseConverter(stringWriter);
		 stringWriter = new StupidRemover(stringWriter);
		 stringWriter = new DuplicateRemover(stringWriter);
		 stringWriter.write("HELLO STUPID STUPID WORLD");
	     System.out.println(stringWriter.toString());
	}

}
