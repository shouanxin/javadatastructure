/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/3/25 11:00.
 */

package com.anxin.map;

import com.alibaba.fastjson.JSON;
import com.anxin.bean.Arc;
import com.anxin.bean.Node;
import com.anxin.bean.PinpointNode;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2020/3/25
 */
public class PinpointMap {


    static Map<String, Node> nodeMap = Maps.newHashMap();
    static List<String> pathList = Lists.newArrayList();
    static String asHome = "mryx-as-home";

    public static void main(String[] args) throws Exception {
        String filePath = "/Users/kotobukiyasushin/Downloads/node.txt";
        FileReader fileReader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data = bufferedReader.readLine();
        System.out.println(data);
        List<PinpointNode> pinpointNodeList = JSON.parseArray(data, PinpointNode.class);
        build(pinpointNodeList);
        String path = "[ " + asHome + " ] --> ";
        printNode(asHome, path);
    }

    public static void build(List<PinpointNode> pinpointMapList) {
        for (PinpointNode pinpointNode : pinpointMapList) {
            buildNode(pinpointNode);
        }
    }

    private static void printNode(String nodeName, String oldPath) {
        if(nodeMap.isEmpty()) {
            System.out.println("node节点为空");
        }
        Node node = nodeMap.get(nodeName);
        if (null == node) {
            pathList.add(oldPath);
            return;
        }
        Arc nextArc = node.getNextArc();

        while (nextArc != null) {
            //String path = oldPath + "[ " + node.getName() + " ] --> ";
            printSimpleArc(nextArc, oldPath);
            nextArc = nextArc.getNextArc();
        }
        printList(pathList);
    }

    private static void printList(List pathList) {
        pathList.forEach(System.out::println);
    }

    private static void printSimpleArc(Arc nextArc, String oldPath) {
        if (nextArc == null) {
            pathList.add(oldPath);
            return;
        }

        String nodeName = nextArc.getNodeName();
        String path = oldPath + "[ " + nodeName + " ] --> ";

        printNode(nodeName, path);
    }

    private static void buildNode(PinpointNode pinpointNode) {
        String parentAppName = pinpointNode.getParentAppName();

        if (!nodeMap.containsKey(parentAppName)) {
            Node node =  Node.builder()
                    .name(parentAppName)
                    .build();
            nodeMap.put(parentAppName, node);
        }

        Node node = nodeMap.get(parentAppName);
        insertArc(node, pinpointNode.getAppName());
    }

    private static void insertArc(Node node, String appName) {
        Arc arc = Arc.builder()
                .nodeName(appName)
                .nextArc(node.getNextArc())
                .build();
        node.setNextArc(arc);
    }
}
