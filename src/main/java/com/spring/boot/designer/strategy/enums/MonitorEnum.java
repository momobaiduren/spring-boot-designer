package com.spring.boot.designer.strategy.enums;

import com.spring.boot.designer.strategy.DemoMonitorInterface;
import com.spring.boot.designer.strategy.monitor.MonitorInterface;

import java.util.Objects;

/**
 * @author zhanglong and since on 2020/3/7 3:30 下午
 */
public enum MonitorEnum {
    DEMO(DemoMonitorInterface.class,"demoBillType", "DEMO", "一个demo的接口监控"),
    ;

    /**
     * 监控接口类
     */
    private Class<? extends MonitorInterface> monitorClass;
    /**
     * 监控单据类型
     */
    private String billType;
    /**
     * 来源系统名称
     */
    private String sourceSystemShortName;
    /**
     * 描述
     */
    private String desc;

    MonitorEnum(Class<? extends MonitorInterface> monitorClass, String billType, String sourceSystemShortName, String desc) {
        this.monitorClass = monitorClass;
        this.billType = billType;
        this.sourceSystemShortName = sourceSystemShortName;
        this.desc = desc;
    }

    public static MonitorEnum fetchEnum(String interfaceName) {
        for (MonitorEnum monitor : MonitorEnum.values()) {
            final Class<? extends MonitorInterface> monitorClass = monitor.monitorClass;
            if (Objects.nonNull(monitorClass) && Objects.equals(monitorClass.getSimpleName(), interfaceName)){
                return monitor;
           }
        }
        throw new RuntimeException("could not configuration this ["+interfaceName+"] interface");
    }

    public Class<? extends MonitorInterface> getMonitorClass() {
        return monitorClass;
    }


}
