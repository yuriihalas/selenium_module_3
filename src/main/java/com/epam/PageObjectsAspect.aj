package com.epam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public aspect PageObjectsAspect {

    pointcut anyPageObjectsMethod(): call(public * com.epam.po..*.* (..));

    pointcut anyBusinessObjectsMethod(): call(public * com.epam.bo..*.* (..));

    before(): anyPageObjectsMethod() || anyBusinessObjectsMethod() {
        Logger log = LogManager.getLogger();
        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
        String message = className + " ";
        message += "method " + thisJoinPoint.getSignature().getName();
        Object[] args = thisJoinPoint.getArgs();
        if (args.length > 0) {
            message += "" + Arrays.toString(args);
        }
        log.info(message);
    }
}
