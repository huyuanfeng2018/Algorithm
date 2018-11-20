package com.practice.sort.ShellSort;

import com.practice.sort.AbsSort;

/**
 * ShellSort
 * ϣ���㷨
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/20</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class ShellSort <T extends Comparable<T>> extends AbsSort<T> {

    /**
     *ϣ���㷨
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
            // 1, 4, 13, 40, ...
        }


        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
