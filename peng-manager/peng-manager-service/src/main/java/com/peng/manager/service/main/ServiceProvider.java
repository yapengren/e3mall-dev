package com.peng.manager.service.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * peng-manager 启动服务类
 *
 * @author renyapeng
 * @date 2018/06/14
 */
public class ServiceProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProvider.class);

    public static void main(String[] args) {
        LOGGER.info(">>>>> peng-manager-service 正在启动 <<<<<");
        com.alibaba.dubbo.container.Main.main(null);
        LOGGER.info(">>>>> peng-manager-service 启动完成 <<<<<");
    }
}
