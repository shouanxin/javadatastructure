/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/4/25 19:08.
 */

package com.anxin.bean;

import lombok.Data;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/4/25
 */
@Data
public class ListNode {
    private int value;

    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
