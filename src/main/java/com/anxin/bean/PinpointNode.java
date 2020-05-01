/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/3/25 10:57.
 */

package com.anxin.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈〉.
 * <p>
 * "parentAppName": "mryx-home-center",// 上级appcode
 * "level": 1, // 层级： 1级；2级；3级；4级
 * "stream": 0, // 0 ： 上游 1 : 下游
 * "appName": "mryx-goods-center"// appcode
 *
 * @author: shouanxin
 * @date: 2020/3/25
 */
@Data
public class PinpointNode implements Serializable {
    /**
     * 上级appcode .
     */
    private String parentAppName;
    /**
     * 层级： 1级；2级；3级；4级 .
     */
    private int level;

    /**  上游 1 : 下游 .*/
    private int stream;

    /** appcode .*/
    private String appName;
}
