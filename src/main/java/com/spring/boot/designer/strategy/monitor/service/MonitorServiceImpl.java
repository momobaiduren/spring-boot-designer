package com.spring.boot.designer.strategy.monitor.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.boot.designer.dao.model.entity.MonitorRecordDO;
import com.spring.boot.designer.strategy.enums.MonitorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

/**
 * @author zhanglong and since on 2020/3/4 7:41 下午
 */
@Slf4j
@Service
public class MonitorServiceImpl extends ServiceImpl<MonitorRecordDO> implements MonitorService {

    @Override
    public void manualCompensate(Set<String> billIds) {
//        if (!CollectionUtils.isNotEmpty(billIds)) {
//            throw new RuntimeException("id cloud not be blank");
//        }
//        QueryWrapper<MonitorRecordDO> ew = new QueryWrapper<>();
//        ew.in("id", billIds);
//        final List<MonitorRecordDO> monitorRecords = monitorRecordRepository.selectList(ew);
//        CollectionUtils.emptyIfNull(monitorRecords).forEach(monitorRecord -> {
//            try {
//                final MonitorResult handler = MonitorFactory.createInterface(MonitorEnum.
//                        fetchEnum(monitorRecord.getInterfaceName())).handler(monitorRecord.getErrBillNo());
//                if (handler.isResult()) {
//                    monitorRecord.setState(1);
//                } else {
//                    monitorRecord.setState(2);
//                }
//                monitorRecord.setErrorMsg(handler.getErrMsg());
//                monitorRecord.setParamJson(handler.getParamJson());
//                monitorRecord.setHandlerTimes(monitorRecord.getHandlerTimes() + 1);
//                DOHelperUtil.ifUserNullSysUpdate(monitorRecord);
//                monitorRecordRepository.updateById(monitorRecord);
//            } catch (Exception e) {
//                log.error("monitor manual compensate fail, billNo is {}", monitorRecord.getErrBillNo());
//            }
//        });
    }

    @Override
    public void monitor(MonitorEnum monitorEnum, String paramJson, String errMsg, Integer billType, String billNo) {
//        QueryWrapper<MonitorRecordDO> ew = new QueryWrapper<>();
//        ew.eq("err_bill_no", billNo);
//        MonitorRecordDO monitorRecord = selectOne(ew);
//        if (Objects.isNull(monitorRecord)){
//            monitorRecord = new MonitorRecordDO();
//        }
//        monitorRecord.setInterfaceName(monitorEnum.name());
//        monitorRecord.setErrorMsg(errMsg);
//        monitorRecord.setParamJson(paramJson);
//        monitorRecord.setBillType(billType);
//        monitorRecord.setErrBillNo(billNo);
//        DOHelperUtil.ifUserNullSysCreate(monitorRecord);
//        monitorRecordRepository.insertOrUpdate(monitorRecord);
    }

}
