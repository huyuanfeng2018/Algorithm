package com.hyf.test;

import java.util.concurrent.*;

/**
 * MainTest
 * �������������ڳ���
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/9/25</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        Callable CallableDemo = new CallableDemo();
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future = es.submit(CallableDemo);
        FutureTask futureTask = new FutureTask(CallableDemo);
        //�ر��̳߳�
        es.shutdown();
        Thread.sleep(1000);
        System.out.println("���߳���ִ����������");
        if (future.isDone() ) {
            //�����ȡ���Ľ��
            System.out.println("future.get()-->" + future.get());
        } else { //�����ȡ���Ľ��
            System.out.println("future.get()δ��ȡ�����");     Thread.sleep(2000);
        }

        System.out.println("���߳���ִ�����");


    }






}
