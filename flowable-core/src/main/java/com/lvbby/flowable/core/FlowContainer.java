
package com.lvbby.flowable.core;

import com.google.common.collect.Maps;
import com.lvbby.flowable.core.utils.FlowableHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 *
 * @author dushang.lp
 * @version $Id: FlowConfigsHolder.java, v 0.1 2020年03月06日 下午6:03 dushang.lp Exp $
 */
public class FlowContainer {
    /***
     * 全局的场景
     */
    private static Map<String, FlowScript> configMap = Maps.newHashMap();

    /***
     * 全局action
     */
    private static Map<String, IFlowAction> actionMap = Maps.newHashMap();

    public static FlowScript getFlowConfig(String code) {
        return configMap.get(code);
    }

    public static IFlowAction getFlowAction(String actionId) {
        return actionMap.get(actionId);
    }

    /***
     * 注册Action
     * @param action
     */
    public static void registerFlowAction(IFlowAction action) {
        String flowActionName = FlowableHelper.getFlowActionName(action);
        if (StringUtils.isNotBlank(flowActionName)) {
            registerFlowAction(flowActionName, action);
        }
    }

    /***
     * 注册Action
     * @param actionId
     * @param action
     */
    public static void registerFlowAction(String actionId, IFlowAction action) {
        if (!actionMap.containsKey(actionId)) {
            actionMap.put(actionId, action);
        }
    }

    public static void addFlowConfig(FlowScript config) {
        configMap.put(config.getCode(), config);
    }

    /**
     * Setter method for property   configMap .
     *
     * @param configMap  value to be assigned to property configMap
     */
    public static void setConfigMap(Map<String, FlowScript> configMap) {
        FlowContainer.configMap = configMap;
    }

    /**
     * Getter method for property   configMap.
     *
     * @return property value of configMap
     */
    public static Map<String, FlowScript> getConfigMap() {
        return configMap;
    }

    /**
     * Getter method for property   actionMap.
     *
     * @return property value of actionMap
     */
    public static Map<String, IFlowAction> getActionMap() {
        return actionMap;
    }

    /**
     * Setter method for property   actionMap .
     *
     * @param actionMap  value to be assigned to property actionMap
     */
    public static void setActionMap(Map<String, IFlowAction> actionMap) {
        FlowContainer.actionMap = actionMap;
    }
}