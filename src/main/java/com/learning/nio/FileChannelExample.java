package com.learning.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelExample {
	public static void main(String[] args) throws IOException {
		RandomAccessFile file=new RandomAccessFile("filechannel.txt", "r");
		FileChannel fileChannel=file.getChannel();
		ByteBuffer byteBuffer=ByteBuffer.allocate(512);
		while(fileChannel.read(byteBuffer) > 0)
		{
			byteBuffer.flip();
			while(byteBuffer.hasRemaining())
			{
				System.out.print((char)byteBuffer.get());
			}
		}
		
		file.close();
	}
}
