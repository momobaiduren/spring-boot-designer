package com.spring.boot.designer.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhanglong since on 2019/12/30 4:41
 */
public class ApplicationEventContext<T> {

    /**
     * description
     */
    private Set<AbstractEventListener<T, ? extends EventSource<T>>> baseEventListeners = new HashSet<>();

    /**
     * 注册监听
     *
     * @param listener 监听器
     */
    public void registerEventListener(AbstractEventListener<T, ? extends EventSource<T>> listener) {
        this.baseEventListeners.add(listener);
    }

    /**
     * 发布事件源
     */
    public <S extends EventSource<T>> void publishEvent(S eventSource) {
        for (AbstractEventListener<T, ?> eventListener : baseEventListeners) {
            //事件监听事件源信息
            eventListener.ifMatchSourceOnEvent(eventSource);
        }
    }

}
