/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/3/25 11:15.
 */

package com.anxin.bean;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2020/3/25
 */
@Data
@Builder
public class Arc implements Serializable {
    private String nodeName;
    private Arc nextArc;
}
