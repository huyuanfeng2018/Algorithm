package com.hyf.test;

import java.util.concurrent.Callable;

/**
 * CallableDemo
 * calla'b'ledemo
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/9/25</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.8
 */
public class CallableDemo implements Callable<Integer> {

    private int sum;


    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        System.out.println("Callable���߳̿�ʼ��������");
        Thread.sleep(3000);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum = sum + i;
        }
        System.out.println("Callable���̼߳��������");
        return sum;
    }
}


