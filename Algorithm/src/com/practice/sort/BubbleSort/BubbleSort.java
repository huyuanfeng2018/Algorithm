package com.practice.sort.BubbleSort;

import com.practice.sort.AbsSort;

/**
 * BubbleSort
 * ð������
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/20</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class BubbleSort<T extends Comparable<T>> extends AbsSort<T> {

    /**
     * ð�������㷨����
     *
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = N-1; i > 0; i--) {
            for (int j = 0; j < i-1 ; j++) {
                if (!less(nums[j], nums[j+1])) {
                    swap(nums, j, j+1);
                }
            }
        }

    }
}
