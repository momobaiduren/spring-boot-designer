package com.spring.boot.designer.strategy.monitor.service;

import com.spring.boot.designer.dao.model.entity.MonitorRecordDO;
import com.spring.boot.designer.strategy.enums.MonitorEnum;
import com.spring.boot.designer.template.TemplateService;

import java.util.Set;

/**
 * @author zhanglong and since on 2020/3/4 7:39 下午
 */
public interface MonitorService extends TemplateService<MonitorRecordDO> {

    void manualCompensate(Set<String> ids);

    void monitor(MonitorEnum monitorEnum, String paramJson, String errMsg, Integer billType, String billNo);
}
