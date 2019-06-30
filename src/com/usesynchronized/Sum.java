package com.usesynchronized;
/*
 * �����ؼ���synchronized���Զ���Ϊ��λ�����������ģ����������κ�λ�ö��κδ���λ�������м��ӣ�����
 * 		����ͬ����
 * 			public synchronized void methodName([parameterList]) {
 * 				//�Թ������Ĳ���
 * 			}
 * 		����ͬ����
 * 			......
 * 			synchronized (Object) {
 * 				//������ʿ��ƵĴ���
 * 			}
 * 			......
 * 		��ʵ�ϣ�����һ����Ҫ�ϳ�ʱ��ִ�еķ�����˵�����з��ʹؼ����ݵ�ʱ����̣ܺܶ������������������Ϊ
 * synchronized�������������߳��޷����ø÷�������ʱ���޷��õ�ִ�У��ⲻ������߳��������Ч�ʡ�
 * ��ʱ���Ϳ���ʹ�ö���ͬ����ֻ�ѷ��ʹؼ����ݵĴ�����û�����������������ǰ�����synchronized(this)���ɡ�
 */
class Sum {
	int sum;
	
	public Sum(int sum) {
		this.sum = sum;
	}
	
	public void addOne() {
		synchronized (this) {	//this����ʵ����������
			sum += 1;	
		}
		
	}
}
