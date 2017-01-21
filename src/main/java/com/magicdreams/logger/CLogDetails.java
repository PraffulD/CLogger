package com.magicdreams.logger;

/**
 * Created by Prafful on 1/21/2017.
 * LogDetails to be added
 */
class CLogDetails {

    private String key;

    private String message;

    private Object[] parameters;

    CLogDetails(String key, String message, Object[] parameters) {
        this.key = key;
        this.message = message;
        this.parameters = parameters;
    }

    String getKey() {
        return key;
    }

    void setKey(String key) {
        this.key = key;
    }

    String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    Object[] getParameters() {
        return parameters;
    }

    void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
