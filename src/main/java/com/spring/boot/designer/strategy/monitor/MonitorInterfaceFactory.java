package com.spring.boot.designer.strategy.monitor;

import com.spring.boot.designer.strategy.enums.MonitorEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhanglong and since on 2020/3/7 3:27 下午
 */
@Slf4j
public class MonitorInterfaceFactory {

    private static final Map<MonitorEnum, MonitorInterface> MONITOR_INTERFACE_MAP = new ConcurrentHashMap<>();

    private MonitorInterfaceFactory() {
    }

    public static MonitorInterface newMonitor(MonitorEnum monitorEnum) {
        final MonitorInterface monitorInterface = MONITOR_INTERFACE_MAP.get(monitorEnum);
        if (Objects.isNull(monitorInterface)) {

            throw new RuntimeException("监控接口未注册");
        }
        return monitorInterface;
    }

    public static void registerMonitor(MonitorEnum monitorEnum, MonitorInterface monitorInterface) {
        MONITOR_INTERFACE_MAP.put(monitorEnum, monitorInterface);
        log.info("interface {} register success", monitorEnum.name());
    }
}
