package com.practice.sort.InsertionSort;

import com.practice.sort.AbsSort;

/**
 * InsertionSort
 * ��������
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/20</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class InsertionSort<T extends Comparable<T>> extends AbsSort<T> {


    /**
     * ��������
     *
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }


    }


}
