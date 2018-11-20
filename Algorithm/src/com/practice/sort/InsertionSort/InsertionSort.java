package com.practice.sort.InsertionSort;

import com.practice.sort.AbsSort;

/**
 * InsertionSort
 * 插入排序
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/11/20</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class InsertionSort<T extends Comparable<T>> extends AbsSort<T> {


    /**
     * 插入排序
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
