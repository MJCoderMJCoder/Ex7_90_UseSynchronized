package com.usesynchronized;

class AddOneThread extends Thread {
	Sum sum;
	
	public AddOneThread(Sum sum) {
		this.sum = sum;
		start();
	}
	
	public void run() {	//必须覆盖Thread类的run()方法
		try {
			Thread.sleep(500); //线程休眠0.5秒、500毫秒
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		sum.addOne();
	}

}
