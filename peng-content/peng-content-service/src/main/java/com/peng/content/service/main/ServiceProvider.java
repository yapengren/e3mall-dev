package com.peng.content.service.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * peng-content 启动服务类
 *
 * @author renyapeng
 * @date 2018/08/03
 */
public class ServiceProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProvider.class);

    public static void main(String[] args) {
        LOGGER.info(">>>>> peng-content-service 正在启动 <<<<<");
        com.alibaba.dubbo.container.Main.main(null);
        LOGGER.info(">>>>> peng-content-service 启动完成 <<<<<");
    }
}
