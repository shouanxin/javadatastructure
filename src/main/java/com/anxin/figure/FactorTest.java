/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/9 17:23.
 */

package com.anxin.figure;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/9
 */
public class FactorTest {
    public static void main(String[] args) {
        int a = 20;
        int b = 100;

        int result = getHighestCommonFactor(a, b);
        System.out.println(result);
    }


    /**
     * 功能描述: 〈获取最大公约数〉.
     *
     * @param a
     * @param b
     * @return int
     * @author shouanxin
     * @date 2019/11/9 17:29
     */
    private static int getHighestCommonFactor(int a, int b) {
        int r = 1;
        while (true) {
            if (a < b) {
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }
            if ((r = a % b) == 0) {
                return b;
            } else {
                if (b < r) {
                    a = r;
                } else {
                    a = b;
                    b = r;
                }
            }
        }
    }
}
