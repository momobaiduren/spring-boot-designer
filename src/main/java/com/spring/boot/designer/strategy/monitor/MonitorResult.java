package com.spring.boot.designer.strategy.monitor;

import lombok.Data;

/**
 * @author zhanglong and since on 2020/3/7 5:40 下午
 */
@Data
public class MonitorResult {
    private String paramJson;

    private String errMsg;

    private boolean result;

    public MonitorResult(String paramJson, String errMsg, boolean result) {
        this.paramJson = paramJson;
        this.errMsg = errMsg;
        this.result = result;
    }

}
