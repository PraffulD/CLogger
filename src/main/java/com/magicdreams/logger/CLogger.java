package com.magicdreams.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Prafful on 1/21/2017.
 * prafful.dhoke@gmail.com
 */
public class CLogger {

    private Logger logger = null;
    private static final DummyLogger DUMMY_LOGGER = new DummyLogger();

    private CLogger() {
    }

    private CLogger(Class clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public static CLogger getLogger(Class clazz) {
        return new CLogger(clazz);
    }

    public CLoggerInterface trace() {
        return logger.isTraceEnabled() ? new MyLogger(LogLevels.TRACE) : DUMMY_LOGGER;
    }

    public CLoggerInterface info() {
        return logger.isInfoEnabled() ? new MyLogger(LogLevels.INFO) : DUMMY_LOGGER;
    }

    public CLoggerInterface debug() {
        return logger.isDebugEnabled() ? new MyLogger(LogLevels.DEBUG) : DUMMY_LOGGER;
    }

    public CLoggerInterface warm() {
        return logger.isWarnEnabled() ? new MyLogger(LogLevels.WARN) : DUMMY_LOGGER;
    }

    public CLoggerInterface error() {
        return logger.isErrorEnabled() ? new MyLogger(LogLevels.ERROR) : DUMMY_LOGGER;
    }

    private class MyLogger implements CLoggerInterface {

        private LogLevels logLevel;

        private StringBuilder message = new StringBuilder();

        private List parameters = new ArrayList();

        private List<CLogDetails> cLogDetailsList = new ArrayList<>();

        private MyLogger() {

        }

        private MyLogger(LogLevels logLevel) {
            this.logLevel = logLevel;
        }

        public void build() {

            createMessageAndParameterFromList();

            switch (logLevel) {
                case TRACE:
                    logger.trace(message.toString(), parameters.toArray());
                    break;
                case INFO:
                    logger.info(message.toString(), parameters.toArray());
                    break;
                case DEBUG:
                    logger.debug(message.toString(), parameters.toArray());
                    break;
                case WARN:
                    logger.warn(message.toString(), parameters.toArray());
                    break;
                case ERROR:
                    logger.error(message.toString(), parameters.toArray());
                    break;
            }
        }

        private void createMessageAndParameterFromList() {
            cLogDetailsList.forEach(v -> {
                message.append("\n\t\t\t\t" + v.getKey())
                        .append(" : ")
                        .append(v.getMessage() + ", ");
                parameters.addAll(Arrays.asList(v.getParameters()));
            });
            if (message.indexOf(",") > 0) {
                message.deleteCharAt(message.lastIndexOf(","));
            }
        }

        public CLoggerInterface forKey(CloggerKeys cloggerKeys, String messeage, Object... parameters) {
            cLogDetailsList.add(new CLogDetails(cloggerKeys.toString(), messeage, parameters));
            return this;
        }

        public CLoggerInterface forMessage(String message, Object... parameters) {
            return forKey(Keys.MESSAGE, message, parameters);
        }

        public CLoggerInterface forId(String message, Object... parameters) {
            return forKey(Keys.ID, message, parameters);
        }

        public CLoggerInterface forUrl(String message, Object... parameters) {
            return forKey(Keys.URL, message, parameters);
        }
    }

    private static class DummyLogger implements CLoggerInterface {

        public void build() {
        }

        public CLoggerInterface forKey(CloggerKeys cloggerKeys, String messeage, Object... parameters) {
            return this;
        }

        public CLoggerInterface forMessage(String messeage, Object... parameters) {
            return this;
        }

        public CLoggerInterface forId(String messeage, Object... parameters) {
            return this;
        }

        public CLoggerInterface forUrl(String messeage, Object... parameters) {
            return this;
        }
    }

    private enum LogLevels {
        TRACE, INFO, DEBUG, WARN, ERROR
    }

    private enum Keys implements CloggerKeys {
        URL, MESSAGE, ID
    }
}
