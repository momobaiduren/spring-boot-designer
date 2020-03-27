package com.spring.boot.designer.strategy.monitor;

import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author zhanglong and since on 2020/3/7 4:00 下午
 */
@Component
public class DemoMonitorInterface implements MonitorInterface {
    @Override
    public MonitorResult handler(String billNo) {
        return null;
    }

    @Override
    public void manualCompensate(Set<String> ids) {

    }
}
