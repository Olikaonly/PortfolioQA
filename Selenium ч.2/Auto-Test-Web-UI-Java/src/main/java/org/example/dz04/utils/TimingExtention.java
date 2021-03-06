package org.example.dz04.utils;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Olga Shestakova
 * Date 26.08.2021
 */
public class TimingExtention implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static Logger logger = LoggerFactory.getLogger(TimingExtention.class);

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        long timeAfterTest = System.currentTimeMillis();
        logger.info("Test execution time {}", timeAfterTest -
                (long) extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("start time"));
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put("start time", System.currentTimeMillis());

    }
}
