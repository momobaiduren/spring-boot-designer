package com.spring.boot.designer.dao.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * 
 * @author zhanglong and since 2020-03-09 09:18:41
 */
@Data
@TableName("sss_monitor_record")
public class MonitorRecordDO {

    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
    * 单据类型
    */
    private Integer billType;
    
    /**
    * 单据id
    */
    private String errBillId;
    
    private String interfaceName;
    
    private String errorMsg;
    
    private String paramJson;
    
    /**
    * 0未处理 1处理成功 2处理失败
    */
    private Integer state;
    
    private Integer handlerTimes;
    
    private LocalDateTime createTime;
    
    private String createBy;
    
    private LocalDateTime updateTime;
    
    private String updateBy;
    

}