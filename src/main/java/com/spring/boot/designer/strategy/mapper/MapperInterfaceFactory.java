package com.spring.boot.designer.strategy.mapper;

import com.spring.boot.designer.strategy.enums.MonitorEnum;
import com.spring.boot.designer.strategy.monitor.MonitorInterface;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhanglong and since on 2020/3/7 4:28 下午
 */
@Slf4j
public class MapperInterfaceFactory {
    private static final Map<MonitorEnum, MonitorInterface> MONITOR_INTERFACE_MAP = new ConcurrentHashMap<>();

    private MapperInterfaceFactory() {
    }

    public static MonitorInterface newMonitor(MonitorEnum monitorEnum) {
        final MonitorInterface monitorInterface = MONITOR_INTERFACE_MAP.get(monitorEnum);
        if (Objects.isNull(monitorInterface)) {
            throw new RuntimeException("monitor interface could not register");
        }
        return monitorInterface;
    }

    public static void registerMonitor(MonitorEnum monitorEnum, MonitorInterface monitorInterface) {
        MONITOR_INTERFACE_MAP.put(monitorEnum, monitorInterface);
        log.info("interface {} register success", monitorEnum.name());
    }

}
