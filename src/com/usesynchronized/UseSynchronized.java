package com.usesynchronized;
/*
 * join()方法也用于控制线程：
 * 如果线程A只有在线程B终止时才能继续执行，则线程A可以调用线程B的join()方法，将两个线程“联结”在一起；
 * 即线程A先执行，而后被挂起，线程B接着执行，直到其终止时线程A回到可运行状态继续执行。
 * 另外join(int time)方法可以传入一个最多等待时间的参数，用于控制等待时间。
 */
public class UseSynchronized {

	public static void main(String[] args) {
		int size = 100;
		for(int t = 0; t < 5; t++) {
			Sum sum = new Sum(0);
			AddOneThread[] rathread = new AddOneThread[size];	//声明数组并创建
			for(int i = 0 ; i < size; i++) {
				try {
					rathread[i] = new AddOneThread(sum); //对象创建，调用构造方法
				} catch (Exception e) {
					e.printStackTrace(); //输出调用堆栈跟踪信息
				}
			}
			
			/*
			 * 必须有这段代码，否则有可能主线程未等到子线程运行完就输出结果
			 * 主函数使用了join()方法，目的是为了等100个线程全部执行后，主线程再输出结果。
			 */
			for(int i = 0; i < size; i++) {
				try {
					//main主线程调用rathread[i]线程的join()方法;等待线程rathread[i]结束后，main主线程在继续执行
					rathread[i].join();
				} catch (InterruptedException e) {
					System.out.println(e.toString()); //返回异常的简短描述，包括异常类名和原因。
				}
			}
			System.out.println("第" + (t+1) + "次，sum=" + sum.sum);
		}
	}
}
