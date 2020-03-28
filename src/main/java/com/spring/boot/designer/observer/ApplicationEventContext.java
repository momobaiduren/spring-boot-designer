package com.spring.boot.designer.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhanglong since on 2019/12/30 4:41
 */
public class ApplicationEventContext<T, S extends EventSource<T>> {

    /**
     * description
     */
    private Set<AbstractEventListener<T, S>> baseEventListeners = new HashSet<>();

    /**
     * 注册监听
     *
     * @param listener 监听器
     */
    public void registerEventListener( AbstractEventListener<T, S> listener ) {
        this.baseEventListeners.add(listener);
    }

    /**
     * 发布事件源
     *
     * @param eventSource 事件源对象
     */
    public void publishEvent( S eventSource ) {
        for (AbstractEventListener<T, S> baseEventListener : baseEventListeners) {
            //事件监听事件源信息
            baseEventListener.onEventListener(eventSource);
        }
    }
}
