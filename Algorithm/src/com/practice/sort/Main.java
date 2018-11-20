package com.practice.sort;

import com.practice.sort.AbsSort;
import com.practice.sort.BubbleSort.BubbleSort;
import com.practice.sort.InsertionSort.InsertionSort;
import com.practice.sort.MergeSort.Down2UpMergeSort;
import com.practice.sort.MergeSort.Up2DownMergeSort;
import com.practice.sort.SelectionSort.SelectionSort;
import com.practice.sort.ShellSort.ShellSort;
import com.practice.sort.Sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Main
 * 主启动类测试(测试各种排序算法的效率和耗时情况)
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/11/20</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class Main {

    private static Logger logger = Logger.getLogger("com.practice.sort.Main");
    private static Map SortClassNameMap = new HashMap(15);

    public static void main(String[] args) throws Exception {
        SortClassNameMap.put("选择排序", SelectionSort.class.getName());
        SortClassNameMap.put("冒泡排序", BubbleSort.class.getName());
        SortClassNameMap.put("插入排序", InsertionSort.class.getName());
        SortClassNameMap.put("希尔排序", ShellSort.class.getName());
        SortClassNameMap.put("自上而下归并排序", Down2UpMergeSort.class.getName());
        SortClassNameMap.put("自下而上归并排序", Up2DownMergeSort.class.getName());

        start("选择排序", 30000, 3);
        start("冒泡排序", 30000, 3);
        start("插入排序", 30000, 3);
        start("希尔排序", 30000, 3);
        start("自上而下归并排序", 30000, 3);
        start("自下而上归并排序", 30000, 3);





    }


    /**
     * 随机生成一个数组的方法
     *
     * @param length 生成数组的长度
     * @param digits 每一个数的位数
     * @return
     */
    private static Integer[] generateNums(int length, int digits) throws Exception {
        if (!(digits > 0) || !(length > 0)) {
            throw new Exception("传入生成数组长度和位数长度都要大于0");
        }
        Integer nums[] = new Integer[length];
        Random random = new Random();
        String s_digits = "";
        for (int i1 = 0; i1 < digits; i1++) {
            s_digits += "9";
        }
        Integer MAXinteger = Integer.valueOf(s_digits);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(MAXinteger);
        }


        return nums;

    }


    /**
     * 返回代理的类
     *
     * @return
     */
    public static Object getProxySort(Sort sort) {
        MyInvacationHandler handler = new MyInvacationHandler(sort);
        Sort Sort = (Sort) Proxy.newProxyInstance(sort.getClass().getClassLoader(), new Class[]{Sort.class}, handler);
        return Sort;
    }


    static class MyInvacationHandler implements InvocationHandler {
        private final Sort sort;
        public MyInvacationHandler(Sort sort) {
            this.sort = sort;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("sort".equals(method.getName())) {
                /*    System.out.println("开始执行排序的算法");*/
                long Start = System.currentTimeMillis();
                Object result = method.invoke(sort, args);
                long End = System.currentTimeMillis();
                System.out.println("结束排序的算法，一共耗时" + (End - Start) + "毫秒");
                return result;
            } else {
                Object result = method.invoke(sort, args);
                return result;
            }
        }
    }

    /**
     * 根据类名来开始各种排序测试工作
     *
     * @param className
     */
    public static void start(String className,int length,int digits) throws Exception {
        /*获取排序算法的类名*/
        String SortClassName = (String) SortClassNameMap.get(className);
        Class<?> clazz = Class.forName(SortClassName);
        Sort sort = (Sort) clazz.newInstance();
        Integer[] selectionintegers = generateNums(length, digits);
        System.out.println("");
        System.out.println("-----------------------" + className + "开始-----------------------");
        System.out.println("---------此次排序的对象为"+length+"个"+digits+"位数的整数-------");
        Sort proxySort = (Sort) getProxySort(sort);
        proxySort.sort(selectionintegers);
        System.out.println("-----------------------" + className + "结束-----------------------");
        System.out.println("");

    }


}
