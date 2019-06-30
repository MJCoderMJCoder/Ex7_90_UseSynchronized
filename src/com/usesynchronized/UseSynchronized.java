package com.usesynchronized;
/*
 * join()����Ҳ���ڿ����̣߳�
 * ����߳�Aֻ�����߳�B��ֹʱ���ܼ���ִ�У����߳�A���Ե����߳�B��join()�������������̡߳����ᡱ��һ��
 * ���߳�A��ִ�У����󱻹����߳�B����ִ�У�ֱ������ֹʱ�߳�A�ص�������״̬����ִ�С�
 * ����join(int time)�������Դ���һ�����ȴ�ʱ��Ĳ��������ڿ��Ƶȴ�ʱ�䡣
 */
public class UseSynchronized {

	public static void main(String[] args) {
		int size = 100;
		for(int t = 0; t < 5; t++) {
			Sum sum = new Sum(0);
			AddOneThread[] rathread = new AddOneThread[size];	//�������鲢����
			for(int i = 0 ; i < size; i++) {
				try {
					rathread[i] = new AddOneThread(sum); //���󴴽������ù��췽��
				} catch (Exception e) {
					e.printStackTrace(); //������ö�ջ������Ϣ
				}
			}
			
			/*
			 * ��������δ��룬�����п������߳�δ�ȵ����߳��������������
			 * ������ʹ����join()������Ŀ����Ϊ�˵�100���߳�ȫ��ִ�к����߳�����������
			 */
			for(int i = 0; i < size; i++) {
				try {
					//main���̵߳���rathread[i]�̵߳�join()����;�ȴ��߳�rathread[i]������main���߳��ڼ���ִ��
					rathread[i].join();
				} catch (InterruptedException e) {
					System.out.println(e.toString()); //�����쳣�ļ�������������쳣������ԭ��
				}
			}
			System.out.println("��" + (t+1) + "�Σ�sum=" + sum.sum);
		}
	}
}
