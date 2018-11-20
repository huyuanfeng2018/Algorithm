package com.practice.sort.SelectionSort;

import com.practice.sort.AbsSort;
import com.practice.sort.Sort;

/**
 * SelectionSort
 * ѡ�������ʵ��
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/20</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class SelectionSort<T extends Comparable<T>> extends AbsSort<T> {


    /**
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int index = i;
            for (int j = i + 1; j < N; j++) {
                if (!less(nums[index], nums[j])) {
                    index = j;
                }
            }
            swap(nums, index, i);
        }


    }

}
