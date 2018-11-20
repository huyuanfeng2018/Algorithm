package com.practice.sort.MergeSort;

import com.practice.sort.AbsSort;
import com.practice.sort.Sort;

/**
 * MergeSort
 * <p>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/20</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public abstract class MergeSort<T extends Comparable<T>> extends AbsSort<T> {

    protected T[] aux;

    protected void merge(T[] nums, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            aux[k] = nums[k]; // �����ݸ��Ƶ���������
        }
        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(nums[j]) <= 0) {
                nums[k] = aux[i++]; // �Ƚ�����һ������֤�ȶ���
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
