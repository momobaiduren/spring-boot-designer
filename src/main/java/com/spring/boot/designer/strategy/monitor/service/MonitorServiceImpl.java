package com.spring.boot.designer.strategy.monitor.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.boot.designer.dao.mapper.MonitorRecordMapper;
import com.spring.boot.designer.dao.model.entity.MonitorRecordDO;
import com.spring.boot.designer.strategy.enums.MonitorEnum;
import com.spring.boot.designer.strategy.monitor.MonitorInterfaceFactory;
import com.spring.boot.designer.strategy.monitor.MonitorResult;
import com.spring.boot.designer.template.impl.TemplateServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author zhanglong and since on 2020/3/4 7:41 下午
 */
@Slf4j
@Service
public class MonitorServiceImpl extends TemplateServiceImpl<MonitorRecordMapper,MonitorRecordDO> implements MonitorService {

    @Override
    public void manualCompensate(Set<String> billIds) {
        if (!CollectionUtils.isNotEmpty(billIds)) {
            throw new RuntimeException("id cloud not be blank");
        }
        QueryWrapper<MonitorRecordDO> ew = new QueryWrapper<>();
        ew.in("id", billIds);
        final List<MonitorRecordDO> monitorRecords = list(ew);
        CollectionUtils.emptyIfNull(monitorRecords).forEach(monitorRecord -> {
            try {
                final MonitorResult handler = MonitorInterfaceFactory.newMonitor(MonitorEnum.
                        fetchEnum(monitorRecord.getInterfaceName())).handler(monitorRecord.getErrBillId());
                if (handler.isResult()) {
                    monitorRecord.setState(1);
                } else {
                    monitorRecord.setState(2);
                }
                monitorRecord.setErrorMsg(handler.getErrMsg());
                monitorRecord.setParamJson(handler.getParamJson());
                monitorRecord.setHandlerTimes(monitorRecord.getHandlerTimes() + 1);
//                DOHelperUtil.ifUserNullSysUpdate(monitorRecord);
                updateById(monitorRecord);
            } catch (Exception e) {
                log.error("monitor manual compensate fail, billNo is {}", monitorRecord.getErrBillId());
            }
        });
    }


    @Override
    public void monitor(MonitorEnum monitorEnum, String paramJson, String errMsg, Integer billType, String billId) {
        QueryWrapper<MonitorRecordDO> ew = new QueryWrapper<>();
        ew.eq("id", billId);
        MonitorRecordDO monitorRecord = getOne(ew);
        if (Objects.isNull(monitorRecord)){
            monitorRecord = new MonitorRecordDO();
        }
        monitorRecord.setInterfaceName(monitorEnum.name());
        monitorRecord.setErrorMsg(errMsg);
        monitorRecord.setParamJson(paramJson);
        monitorRecord.setBillType(billType);
        monitorRecord.setErrBillId(billId);
//        DOHelperUtil.ifUserNullSysCreate(monitorRecord);
        saveOrUpdate(monitorRecord);
    }

}
