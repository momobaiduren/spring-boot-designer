package com.spring.boot.designer.strategy;

import com.spring.boot.designer.strategy.enums.MonitorEnum;
import com.spring.boot.designer.strategy.monitor.MonitorInterface;
import com.spring.boot.designer.strategy.monitor.MonitorInterfaceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhanglong and since on 2020/3/7 3:35 下午
 */
@Slf4j
@Component
public class SpringApplicationRunner implements ApplicationRunner {

    @Resource
    private ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) {
        final MonitorEnum[] values = MonitorEnum.values();
        for (MonitorEnum value : values) {
            final Class<? extends MonitorInterface> monitorClass = value.getMonitorClass();
            if (Objects.isNull(monitorClass)) {
                continue;
            }
            MonitorInterfaceFactory.registerMonitor(value, context.getBean(monitorClass));
        }
    }
}
