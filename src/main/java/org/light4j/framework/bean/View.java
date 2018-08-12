package org.light4j.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author weimiantong
 * @date 18/7/29
 */
public class View {
    /**
     *  视图路径
     */
    private String path;

    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<String, Object>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
