package com.usesynchronized;

class AddOneThread extends Thread {
	Sum sum;
	
	public AddOneThread(Sum sum) {
		this.sum = sum;
		start();
	}
	
	public void run() {	//���븲��Thread���run()����
		try {
			Thread.sleep(500); //�߳�����0.5�롢500����
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		sum.addOne();
	}

}
