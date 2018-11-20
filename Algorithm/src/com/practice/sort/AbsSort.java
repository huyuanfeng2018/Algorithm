package com.practice.sort;

/**
 * AbsSort
 * <p>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/20</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public abstract class AbsSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    @Override
    public void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
