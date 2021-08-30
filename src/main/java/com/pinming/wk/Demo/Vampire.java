package com.pinming.wk.Demo;

import java.util.ArrayList;


/**
 * 先从1001开始到9999开始判断，是否能分解为两个二位数，如果可以，二维数是否包含所有四个数字
 * 把四位数分解成二位数乘积过于麻烦，而且一个四位数可能存在多种分解方式，加大了设计的难度
 * 但是反过来，二位数乘以二位数简单得多，此时再去判断即可
 * 将积分解成四个数位，存入数组。两个乘数分别分解成两个数位，存入一个数组
 * 将两个数组排序，按照下标逐个比较，如果两个数组相同，返回true
 *
 * @author zhaoke
 */
public class Vampire {

    //冒泡排序法
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    //交换两个数的位置
                    array[i] = array[i] - array[j];
                    array[j] = array[i] + array[j];
                    array[i] = array[j] - array[i];
                }
            }
        }
    }

    /**
     * 判断四位数分解后的数位(存在数组里)，是否恰好包含两个乘积因子的所有数位
     * 为了简单起见，方法是先排序，然后比较两个数组是否相同
     */
    public boolean check(int[] digits, int num1, int num2) {
        this.sort(digits);
//        System.out.println(Arrays.toString(digits));

        int[] factors = new int[4];
        //分离第一个乘数的两个数位
        int[] numArray = this.divideNumber(num1);
        for (int i = 0; i < 2; i++) {
            factors[i] = numArray[i];
        }
        //分离第二个乘数的两个数位
        numArray = this.divideNumber(num2);
        for (int i = 2; i < 4; i++) {
            factors[i] = numArray[i - 2];
        }
        this.sort(factors);
//        System.out.println(Arrays.toString(factors));
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != factors[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] divideNumber(int number) {
        int[] digits = new int[2];
        digits[0] = number / 10;
        digits[1] = number - 10 * (number / 10);
        return digits;
    }

    /**
     * 获得每个位的数字
     */
    public int[] divideArray(int number) {
        int[] digits = new int[4];
        int factor = 1000;
        for (int i = 0; i < digits.length; i++) {
            digits[i] = number / factor;
            number -= digits[i] * factor;
            factor /= 10;
        }
        return digits;
    }

    ArrayList<Integer> result = new ArrayList<Integer>();

    /**
     * 10*99小于1000，因此从11开始循环
     */
    public void start() {
        int count = 0; //计数器而已
        for (int i = 11; i < 100; i++) {
            for (int j = 11; j < 100; j++) {
                if (i * j < 1000)
                    continue;
                if (i * j % 100 == 0) {
                    //根据题目,如果最后两位是0,也不可
                    continue;
                }
                int[] digits = divideArray(i * j);
                if (this.check(digits, i, j)) {
                    if (this.result.contains(i * j))
                        continue;
                    this.result.add(i * j);
                    System.out.printf("第%d个吸血鬼数: %d = %d x %d \n", ++count, i * j, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vampire v = new Vampire();
        v.start();
    }


}
