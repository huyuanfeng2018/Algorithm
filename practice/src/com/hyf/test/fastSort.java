package com.hyf.test;

/**
 * ��д�˴������㷨
 * ��������
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/9/25</BR>
 *���������㷨
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class fastSort {


    private int[] result;

    public static void main(String[] args) {
        /*��ʼ��һ������ Ȼ�������������*/
        int[] randomArs = NumberUtils.getRandomArs(50000, 5154487);
        int[] randomArs2 = randomArs.clone();

        System.out.println("��������ʼ");
        Long starkuaisu = System.currentTimeMillis();
        sort(randomArs, 0, randomArs.length - 1);
        System.out.println("�ܹ���ʱ" + (System.currentTimeMillis() - starkuaisu));
        System.out.println("�����������");


        System.out.println("ð������ʼ");
        Long starmaopao = System.currentTimeMillis();
        sortMaopao(randomArs2);
        System.out.println("�ܹ���ʱ" + (System.currentTimeMillis() - starmaopao));
        System.out.println("�����������");




    }





    private static void sort(int[] intArrays ,int left,int right) {
        //���������������������ֱ�ӷ���
        if(left > right){
            return;
        }
        int i = left ;
        int j = right;
        int temp = intArrays[left];//���û�׼ֵ���������Ԫ����Ϊ��׼ֵ
        while(i != j){
            //������λ��ֱ��С��temp
            while(i<j && intArrays[j]>=temp){
                j--;
            }
            //������λ��ֱ������temp
            while(i<j && intArrays[i]<=temp){
                i++;
            }
            if(i < j){
                //���i<j,Ҳ����˵i��j��û����ʱ�������˴˵�����
                NumberUtils.exchange(intArrays,i,j);
            }
        }
        //���ڱ�i���ڱ�j����ʱ�˳�ѭ�������ڱ�i���λ����λ��
        NumberUtils.exchange(intArrays,left,i);
        //��һ�ε���
        sort(intArrays,left,i-1);//����
        sort(intArrays,j+1,right);//�Ұ��
    }


    /**
     * ð�������㷨
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
