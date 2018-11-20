package com.practice.sort.SelectionSort;

import com.practice.sort.AbsSort;
import com.practice.sort.Sort;

/**
 * SelectionSort
 * 选择排序的实现
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/11/20</BR>
 *
 * @author 胡源锋
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
