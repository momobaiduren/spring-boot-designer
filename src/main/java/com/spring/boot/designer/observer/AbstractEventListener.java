package com.spring.boot.designer.observer;

import java.util.EventListener;
import java.util.Objects;

/**
 * @author zhanglong and since  2019/12/30  4:42
 */
public abstract class AbstractEventListener<T, S extends EventSource<T>> implements EventListener {
    /**
     * description 监听事件
     *
     * @param eventSource 事件源
     */
    public abstract void onEventListener(S eventSource);

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * description 获取事件源类型
     */
    public abstract Class<S> getListenerSourceClass();

    /**
     * description 匹配事件源发布事件到监听器
     */
    public <G extends EventSource<T>> void ifMatchSourceOnEvent(G source) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(getListenerSourceClass());
        if (source.getClass().isAssignableFrom(getListenerSourceClass())) {
            onEventListener((S) source);
        }
    }
}
