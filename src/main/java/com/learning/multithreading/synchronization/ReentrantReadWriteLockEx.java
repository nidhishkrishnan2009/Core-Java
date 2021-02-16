package com.learning.multithreading.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockEx {
	public static void main(String[] args) {
		DataReadWrite<String> StringReadWriter = new DataReadWrite<>();
		ExecutorService executors = Executors.newFixedThreadPool(2);
		Runnable reader1 = new ReadThread<String>(StringReadWriter, 0, "job1");
		Runnable reader2 = new ReadThread<String>(StringReadWriter, 1, "job2");
		Runnable writer1 = new WriteThread<String>(StringReadWriter, "Nidish Naija", "job3");
		Runnable writer2 = new WriteThread<String>(StringReadWriter, "Rahul Dravid", "job3");
		executors.execute(writer1);
		executors.execute(writer2);
		executors.execute(reader1);
		executors.execute(reader2);

		executors.shutdown();
	}
}

class DataReadWrite<T> {
	private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
	private List<T> elementList = new ArrayList<T>();

	public boolean setElement(T t) {
		final Lock writeLock = RW_LOCK.writeLock();
		writeLock.lock();
		try {
			return elementList.add(t);
		}

		finally {
			writeLock.unlock();
		}
	}

	public T getElement(int i) {
		if (elementList.isEmpty())
			return null;
		else {
			Lock readLock = RW_LOCK.readLock();
			readLock.lock();
			try {
				return elementList.get(i);
			}

			finally {
				readLock.unlock();
			}

		}
	}

}

class ReadThread<T> implements Runnable {
	private DataReadWrite<T> dataReadWrite;
	private int readElem;
	private String threadName;

	public ReadThread(DataReadWrite<T> dataReadWrite, int readElem, String threadName) {
		this.dataReadWrite = dataReadWrite;
		this.readElem = readElem;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		System.out.println(threadName + " is reading " + dataReadWrite.getElement(readElem));
	}
}

class WriteThread<T> implements Runnable {
	private DataReadWrite<T> dataReadWrite;
	private T writeElem;
	private String threadName;

	public WriteThread(DataReadWrite<T> dataReadWrite, T writeElem, String threadName) {
		this.dataReadWrite = dataReadWrite;
		this.writeElem = writeElem;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		if (dataReadWrite.setElement(writeElem))
			System.out.println(threadName + " has written the element " + writeElem);
	}
}