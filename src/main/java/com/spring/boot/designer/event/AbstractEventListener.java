package com.spring.boot.designer.event;
import java.util.EventListener;

/**
 * @author zhanglong and since  2019/12/30  4:42
 */
public abstract class AbstractEventListener<T, S extends EventSource<T>> implements EventListener {
    /**
     * description 监听事件
     * @param eventSource 事件源
     */
    public abstract void onEventListener( S eventSource );

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals( Object obj ) {
        return super.equals(obj);
    }
}
