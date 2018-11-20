package com.practice.sort;

/**
 * Sort
 * 排序算法的抽象接口类  定义了交换位置和比较的方法以及排序算法抽象方法
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/11/20</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * 排序算法的抽象方法
     *
     * @param nums
     */
    public void sort(T[] nums);

    boolean less(T v, T w);

    void swap(T[] a, int i, int j);

}
