package org.fb.utils.qa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

    private static Logger logger = LogManager.getLogger(LogUtil.class);

    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}

