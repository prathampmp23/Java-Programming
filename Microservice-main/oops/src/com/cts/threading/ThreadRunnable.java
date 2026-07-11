package com.cts.threading;

public class ThreadRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 4; i++) {
			try {
				Thread.sleep(2000); // 2sec delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread " + i);
		}
	}

	public static void main(String[] args) {
		ThreadRunnable r1 = new ThreadRunnable();
		Thread t1 = new Thread(r1);
		t1.start();
		ThreadRunnable r2 = new ThreadRunnable();
		Thread t2 = new Thread(r2);
		t2.start();

	}

}
