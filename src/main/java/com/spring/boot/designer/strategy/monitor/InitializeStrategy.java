package com.spring.boot.designer.strategy.monitor;

import com.spring.boot.designer.strategy.enums.MonitorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhanglong and since on 2020/3/28 12:21 下午
 */
@Slf4j
@Component
public class InitializeStrategy implements InitializingBean {
    @Resource
    private ApplicationContext context;

    @Override
    public void afterPropertiesSet() {
        log.info("开始加载监控配置");
        for (MonitorEnum monitor : MonitorEnum.values()) {
            final Class<? extends MonitorInterface> monitorClass = monitor.getMonitorClass();
            if (Objects.nonNull(monitorClass)) {
                try {
                    final MonitorInterface monitorInterface = context.getBean(monitorClass);
                    MonitorInterfaceFactory.registerMonitor(monitor, monitorInterface);
                } catch (BeansException e) {
                    throw new RuntimeException("monitor interface [" + monitorClass.getSimpleName() + "] do not initialized spring context,could not get this interface resource ");
                }
            }
        }
        log.info("完成加载监控配置");
    }
}
