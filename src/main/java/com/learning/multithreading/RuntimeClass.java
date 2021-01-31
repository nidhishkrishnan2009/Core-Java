package com.learning.multithreading;

import java.io.IOException;

/**
 * 
 * @author Krishnan
 *Java Runtime class is used to interact with java runtime environment (jre). 
 *getRuntime() returns singleton instance of Runtime class. 
 */
public class RuntimeClass {

	public static void main(String[] args) throws IOException {
		Runtime r=Runtime.getRuntime();
		// exec() is used to execute command.
		r.exec("notepad");
		System.out.println("avaiable processors ="+r.availableProcessors());
		// adding shutdown hook
		r.addShutdownHook(new Thread() {
			@Override
			public void run()
			{
				System.out.println("Shutting down!");
			}
		});
		System.out.println("Total memory available in JVM for current & future objects ="+r.totalMemory());
		System.out.println("Total free memory in JVM ="+r.freeMemory());
		System.out.println("Maximum memory that JVM can use ="+r.maxMemory());
	}
}
