package com.magicdreams.logger;

/**
 * Created by Prafful on 1/21/2017.
 * LogDetails to be added
 */
public class CLogDetails {

    private String key;

    private String message;

    private Object[] parameters;

    public CLogDetails(String key, String message, Object[] parameters) {
        this.key = key;
        this.message = message;
        this.parameters = parameters;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
