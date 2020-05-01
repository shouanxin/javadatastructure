/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/3/25 22:39.
 */

package com.anxin.hailstone;

import org.junit.Test;

/**
 * 〈〉.
 * * HailStone序列
 * * n=1时，返回1；
 * * n>1时且为偶数时，{n} ∪ {n/2}
 * * n>1时且为奇数时，{n} ∪ {3n + 1}
 *
 * @author: shouanxin
 * @date: 2020/3/25
 */
public class Hailstone {

    /**
     * 功能描述: 〈计算序列n的长度〉.
     *
     * @param n
     * @return  int
     * @author shouanxin
     * @date  2020/3/25 22:40
     */
    public int hailstoneLength(int n) {
        // 从1开始，累计步数，直到n=1
        int length = 1;
        while (1 < n) {
            n = (n % 2) == 1 ? 3 * n + 1 : n / 2;
            System.out.println(n);
            length ++;
        }
        return length;
    }

    @Test
    public void test() {
        System.out.println(hailstoneLength(27));
    }
}
