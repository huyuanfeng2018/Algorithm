package com.practice.sort.ShellSort;

import com.practice.sort.AbsSort;

/**
 * ShellSort
 * 希尔算法
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/11/20</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class ShellSort <T extends Comparable<T>> extends AbsSort<T> {

    /**
     *希尔算法
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
