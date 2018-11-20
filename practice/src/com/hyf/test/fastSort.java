package com.hyf.test;

/**
 * 手写八大排序算法
 * 快速排序
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/9/25</BR>
 *快速排序算法
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class fastSort {


    private int[] result;

    public static void main(String[] args) {
        /*初始化一个数组 然后对他进行排序*/
        int[] randomArs = NumberUtils.getRandomArs(50000, 5154487);
        int[] randomArs2 = randomArs.clone();

        System.out.println("快速排序开始");
        Long starkuaisu = System.currentTimeMillis();
        sort(randomArs, 0, randomArs.length - 1);
        System.out.println("总共耗时" + (System.currentTimeMillis() - starkuaisu));
        System.out.println("快速排序结束");


        System.out.println("冒泡排序开始");
        Long starmaopao = System.currentTimeMillis();
        sortMaopao(randomArs2);
        System.out.println("总共耗时" + (System.currentTimeMillis() - starmaopao));
        System.out.println("快速排序结束");




    }





    private static void sort(int[] intArrays ,int left,int right) {
        //如果左索引大于右索引，直接返回
        if(left > right){
            return;
        }
        int i = left ;
        int j = right;
        int temp = intArrays[left];//设置基准值，将最左端元素作为基准值
        while(i != j){
            //往左移位，直到小于temp
            while(i<j && intArrays[j]>=temp){
                j--;
            }
            //往右移位，直到大于temp
            while(i<j && intArrays[i]<=temp){
                i++;
            }
            if(i < j){
                //如果i<j,也就是说i和j还没相遇时，交换彼此的数据
                NumberUtils.exchange(intArrays,i,j);
            }
        }
        //当哨兵i与哨兵j相遇时退出循环，将哨兵i与基位交换位置
        NumberUtils.exchange(intArrays,left,i);
        //下一次迭代
        sort(intArrays,left,i-1);//左半边
        sort(intArrays,j+1,right);//右半边
    }


    /**
     * 冒泡排序算法
     */
    private static void  sortMaopao(int[] intArrays) {
        for (int i = intArrays.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (intArrays[j] > intArrays[j + 1]) {
                    exChange(intArrays, j, j + 1);
                }
            }
            

        }




    }


    private static  void  exChange(int[] intArrays, int i, int j) {
        int temp = intArrays[i];
        intArrays[i] = intArrays[j];
        intArrays[j] = temp;
    }


}
