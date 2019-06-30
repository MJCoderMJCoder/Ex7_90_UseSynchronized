package com.usesynchronized;
/*
 * ？？关键字synchronized是以对象为单位建立监视器的，并不能再任何位置对任何代码段或变量进行监视：？？
 * 		方法同步：
 * 			public synchronized void methodName([parameterList]) {
 * 				//对共享对象的操作
 * 			}
 * 		对象同步：
 * 			......
 * 			synchronized (Object) {
 * 				//允许访问控制的代码
 * 			}
 * 			......
 * 		事实上，对于一个需要较长时间执行的方法来说，其中访问关键数据的时间可能很短，如果将整个方法申明为
 * synchronized，将导致其他线程无法调用该方法而长时间无法得到执行，这不利于提高程序的运行效率。
 * 这时，就可以使用对象同步，只把访问关键数据的代码段用花括号括起来，在其前面加上synchronized(this)即可。
 */
class Sum {
	int sum;
	
	public Sum(int sum) {
		this.sum = sum;
	}
	
	public void addOne() {
		synchronized (this) {	//this代表实例对象自身
			sum += 1;	
		}
		
	}
}
