package com.spring.boot.designer.strategy.monitor;


import java.util.Set;

/**
 * @author zhanglong and since on 2020/3/4 7:05 下午
 */

public interface MonitorInterface {
    /**
     * 外部接口处理并返回处理结果
     */
    MonitorResult handler(String billNo);
    /**
     * 失败消息的告警
     * 可以不实现
     */
    default void failToWarn(){}
    /**
     * 手工补偿
     */
    void manualCompensate(Set<String> ids);
}
