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
 * �����������(���Ը��������㷨��Ч�ʺͺ�ʱ���)
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/20</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class Main {

    private static Logger logger = Logger.getLogger("com.practice.sort.Main");
    private static Map SortClassNameMap = new HashMap(15);

    public static void main(String[] args) throws Exception {
        SortClassNameMap.put("ѡ������", SelectionSort.class.getName());
        SortClassNameMap.put("ð������", BubbleSort.class.getName());
        SortClassNameMap.put("��������", InsertionSort.class.getName());
        SortClassNameMap.put("ϣ������", ShellSort.class.getName());
        SortClassNameMap.put("���϶��¹鲢����", Down2UpMergeSort.class.getName());
        SortClassNameMap.put("���¶��Ϲ鲢����", Up2DownMergeSort.class.getName());

        start("ѡ������", 30000, 3);
        start("ð������", 30000, 3);
        start("��������", 30000, 3);
        start("ϣ������", 30000, 3);
        start("���϶��¹鲢����", 30000, 3);
        start("���¶��Ϲ鲢����", 30000, 3);





    }


    /**
     * �������һ������ķ���
     *
     * @param length ��������ĳ���
     * @param digits ÿһ������λ��
     * @return
     */
    private static Integer[] generateNums(int length, int digits) throws Exception {
        if (!(digits > 0) || !(length > 0)) {
            throw new Exception("�����������鳤�Ⱥ�λ�����ȶ�Ҫ����0");
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
     * ���ش������
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
                /*    System.out.println("��ʼִ��������㷨");*/
                long Start = System.currentTimeMillis();
                Object result = method.invoke(sort, args);
                long End = System.currentTimeMillis();
                System.out.println("����������㷨��һ����ʱ" + (End - Start) + "����");
                return result;
            } else {
                Object result = method.invoke(sort, args);
                return result;
            }
        }
    }

    /**
     * ������������ʼ����������Թ���
     *
     * @param className
     */
    public static void start(String className,int length,int digits) throws Exception {
        /*��ȡ�����㷨������*/
        String SortClassName = (String) SortClassNameMap.get(className);
        Class<?> clazz = Class.forName(SortClassName);
        Sort sort = (Sort) clazz.newInstance();
        Integer[] selectionintegers = generateNums(length, digits);
        System.out.println("");
        System.out.println("-----------------------" + className + "��ʼ-----------------------");
        System.out.println("---------�˴�����Ķ���Ϊ"+length+"��"+digits+"λ��������-------");
        Sort proxySort = (Sort) getProxySort(sort);
        proxySort.sort(selectionintegers);
        System.out.println("-----------------------" + className + "����-----------------------");
        System.out.println("");

    }


}
