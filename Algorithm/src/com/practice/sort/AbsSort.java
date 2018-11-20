package com.practice.sort;

/**
 * AbsSort
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/11/20</BR>
 *
 * @author 胡源锋
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
