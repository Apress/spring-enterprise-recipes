package com.apress.springenterpriserecipes.report;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.PropertyUtils;

public class Container {

    private Map<String, Object> components;

    public Container() {
        components = new HashMap<String, Object>();

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("components.properties"));
            for (Map.Entry entry : properties.entrySet()) {
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                processEntry(key, value);
            }
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    private void processEntry(String key, String value) throws Exception {
        String[] parts = key.split("\\.");

        if (parts.length == 1) {
            // New component definition
            Object component = Class.forName(value).newInstance();
            components.put(parts[0], component);
        } else {
            // Dependency injection
            Object component = components.get(parts[0]);
            Object reference = components.get(value);
            PropertyUtils.setProperty(component, parts[1], reference);
        }
    }

    public Object getComponent(String id) {
        return components.get(id);
    }
}
