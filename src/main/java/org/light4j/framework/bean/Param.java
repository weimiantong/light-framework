package org.light4j.framework.bean;

import org.light4j.framework.util.CastUtil;

import java.util.Map;

/**
 *
 * @author weimiantong
 * @date 18/7/29
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }

    public Map<String,Object> getFieldMap() {
        return null;
    }
}
