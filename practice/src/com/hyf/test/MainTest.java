package com.hyf.test;

import java.util.concurrent.*;

/**
 * MainTest
 * 测试主函数所在程序
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/9/25</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        Callable CallableDemo = new CallableDemo();
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future = es.submit(CallableDemo);
        FutureTask futureTask = new FutureTask(CallableDemo);
        //关闭线程池
        es.shutdown();
        Thread.sleep(1000);
        System.out.println("主线程在执行其他任务");
        if (future.isDone() ) {
            //输出获取到的结果
            System.out.println("future.get()-->" + future.get());
        } else { //输出获取到的结果
            System.out.println("future.get()未获取到结果");     Thread.sleep(2000);
        }

        System.out.println("主线程在执行完成");


    }






}
