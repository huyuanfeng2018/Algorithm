package com.hyf.test;

import java.util.Random;

public class NumberUtils {
    /**
     * ��ȡ���int��������
     */
    public static int[] getRandomArs(int length, int max) {
        int rs[] = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            rs[i] = random.nextInt(max);
        }
        return rs;
    }

    /**
     * ��ӡ����
     */
    public static void display(int intArrays[], int type) {
        int count = 0;
        if (type == 2) {
            System.out.print("�����");
        } else if (type == 1) {
            System.out.print("����ǰ��");
        }
        if (intArrays.length < 40) {
            for (int i : intArrays) {
                System.out.print(i + " ");
            }
        } else {
            for (int i : intArrays) {
                count++;
                if (count < 10) {
                    System.out.print(i + " ");
                } else if (count == 10) {
                    System.out.print("......");
                } else if (count > intArrays.length - 10) {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }

    /**
     * ������������������λ��
     */
    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

