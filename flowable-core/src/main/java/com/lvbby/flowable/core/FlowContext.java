package com.lvbby.flowable.core;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 *
 * @author dushang.lp
 * @version $Id: IFlowContext.java, v 0.1 2020年03月06日 下午5:03 dushang.lp Exp $
 */
public class FlowContext {

    protected FlowScript config;

    private String code;

    protected Map<String, Object> data;

    public FlowContext(String code) {
        this.code = code;
    }

    public FlowContext() {
    }

    public <T> T getValue(String key) {
        return (T) ensureData().get(key);
    }

    public String getValueString(String key) {
        return getValue(key);
    }

    public boolean hasValue(String key){
        return getValue(key)!=null;
    }

    private Map<String, Object> ensureData() {
        if (data == null) {
            data = Maps.newHashMap();
        }
        return data;
    }

    public FlowContext putValue(String key, Object value) {
        if (null != value && StringUtils.isNotBlank(key)) {
            ensureData().put(key, value);
        }
        return this;
    }

    /**
     * Getter method for property   config.
     *
     * @return property value of config
     */
    public FlowScript getConfig() {
        return config;
    }

    /**
     * Setter method for property   config .
     *
     * @param config  value to be assigned to property config
     */
    public void setConfig(FlowScript config) {
        this.config = config;
    }

    /**
     * Getter method for property   code.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property   code .
     *
     * @param code  value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property   data.
     *
     * @return property value of data
     */
    public Map<String, Object> getData() {
        return data;
    }

    /**
     * Setter method for property   data .
     *
     * @param data  value to be assigned to property data
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}