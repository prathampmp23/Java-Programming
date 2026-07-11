package com.cts.threading;

public class MainThread extends Thread {

	public void run() {
		for (int i = 0; i <= 4; i++) {
			try {
				Thread.sleep(2000); // 2sec delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MainThread t1 = new MainThread();
		t1.start();
		t1.join();
		MainThread t2 = new MainThread();
		t2.start();
	}

}
