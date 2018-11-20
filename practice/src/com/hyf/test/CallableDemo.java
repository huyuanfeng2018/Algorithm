package com.hyf.test;

import java.util.concurrent.Callable;

/**
 * CallableDemo
 * calla'b'ledemo
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/9/25</BR>
 *
 * @author 胡源锋
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
        System.out.println("Callable子线程开始计算啦！");
        Thread.sleep(3000);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum = sum + i;
        }
        System.out.println("Callable子线程计算结束！");
        return sum;
    }
}


