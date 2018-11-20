package com.practice.sort;

/**
 * Sort
 * �����㷨�ĳ���ӿ���  �����˽���λ�úͱȽϵķ����Լ������㷨���󷽷�
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/20</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * �����㷨�ĳ��󷽷�
     *
     * @param nums
     */
    public void sort(T[] nums);

    boolean less(T v, T w);

    void swap(T[] a, int i, int j);

}
