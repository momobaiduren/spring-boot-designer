package com.spring.boot.designer.template;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author zhanglong and since on 2020/3/28 12:00 下午
 *
 * 模版接口
 * 使用于没有差异性的公共业务抽取
 * 可以定义公共的模版类，比如单表导出
 */
public interface TemplateService<T> extends IService<T> {
}
