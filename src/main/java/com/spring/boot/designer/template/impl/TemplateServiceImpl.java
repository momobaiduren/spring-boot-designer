package com.spring.boot.designer.template.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.boot.designer.template.TemplateService;
import org.springframework.stereotype.Service;

/**
 * @author zhanglong and since on 2020/3/28 12:07 下午
 */
@Service
public class TemplateServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M , T> implements TemplateService<T> {

}
