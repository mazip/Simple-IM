//
//  ========================================================================
//  Copyright (c) 1995-2016 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.mazip.util.component;


import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Basic implementation of the life cycle interface for components.
 */
public abstract class AbstractLifeCycle implements LifeCycle {

    private final CopyOnWriteArrayList<LifeCycleListener> _listeners = new CopyOnWriteArrayList<LifeCycleListener>();
    //锁
    private final Object _lock = new Object();
    private final int __FAILED = -1, __STOPPED = 0, __INITIALIZE=1,__STARTED = 2, __STARTING = 3, __SUSPEND = 4, __STOPPING = 5,__RESUME=6;
    //初始状态是stopped
    private volatile int _state = __STOPPED;
    private long _stopTimeout = 30000;

    /**
     * 留给子类实现
     * 启动的方法
     * @throws Exception
     */
    protected void doStart() throws Exception {
    }

    /**
     * 留给子类实现关闭的方法
     * @throws Exception
     */
    protected void doStop() throws Exception {
    }


    /**
     * 启动的方法
     * @throws Exception
     */
    public final void start() throws Exception {
        synchronized (_lock) {
            try {
                //判断状态 如果是运行状态就直接返回
                if (_state == __STARTED || _state == __STARTING)
                    return;
                setStarting();
                doStart();
                setStarted();
            } catch (Throwable e) {
                setFailed(e);
            }
        }
    }

    /**
     * 关闭的方法
     * @throws Exception
     */
    public final void stop() throws Exception {
        synchronized (_lock) {
            try {
                //判断是否是正在关闭的状态
                if (_state == __STOPPING || _state == __STOPPED)
                    return;
                setStopping();
                doStop();
                setStopped();
            } catch (Throwable e) {
                setFailed(e);

            }
        }
    }


    public boolean isRunning() {
        final int state = _state;
        return state == __STARTED || state == __STARTING;
    }


    public boolean isStarted() {
        return _state == __STARTED;
    }


    public boolean isStarting() {
        return _state == __STARTING;
    }


    public boolean isStopping() {
        return _state == __STOPPING;
    }


    public boolean isStopped() {
        return _state == __STOPPED;
    }


    public boolean isFailed() {
        return _state == __FAILED;
    }

    public boolean isSuspend(){
        return _state==__SUSPEND;
    }

    public boolean isResume(){
        return _state==__RESUME;
    }

    public void addLifeCycleListener(LifeCycleListener listener) {
        _listeners.add(listener);
    }


    public void removeLifeCycleListener(LifeCycleListener listener) {
        _listeners.remove(listener);
    }

    public LifeCycleState getState() {
        switch (_state) {
            case __FAILED:
                return LifeCycleState.FAILED;
            case __INITIALIZE:
                return LifeCycleState.INITIALIZE;
            case __STARTING:
                return LifeCycleState.STARTTING;
            case __STARTED:
                return LifeCycleState.STARTED;
            case __STOPPING:
                return LifeCycleState.STOPPING;
            case __STOPPED:
                return LifeCycleState.STOPPED;
            case __SUSPEND:
                return LifeCycleState.SUSPEND;
            case __RESUME:
                return LifeCycleState.RESUME;
        }
        return null;
    }

    public static LifeCycleState getState(LifeCycle lc) {
        if (lc.isStarting()) return LifeCycleState.STARTTING;
        if (lc.isStarted()) return LifeCycleState.STARTED;
        if (lc.isStopping()) return LifeCycleState.STOPPING;
        if (lc.isStopped()) return LifeCycleState.STOPPED;
        if(lc.isSuspend()) return LifeCycleState.SUSPEND;
        if(lc.isResume()) return LifeCycleState.RESUME;
        return LifeCycleState.FAILED;
    }

    private void setStarted() {
        _state = __STARTED;
        for (LifeCycleListener listener : _listeners)
            listener.lifeCycleStarted(this);
    }

    private void setStarting() {
        _state = __STARTING;
        for (LifeCycleListener listener : _listeners)
            listener.lifeCycleStarting(this);
    }

    private void setStopping() {
        _state = __STOPPING;
        for (LifeCycleListener listener : _listeners)
            listener.lifeCycleStopping(this);
    }

    private void setStopped() {
        _state = __STOPPED;
        for (LifeCycleListener listener : _listeners)
            listener.lifeCycleStopped(this);
    }

    private void setFailed(Throwable th) {
        _state = __FAILED;

        for (LifeCycleListener listener : _listeners)
            listener.lifeCycleFailure(this, th);
    }

    public long getStopTimeout() {
        return _stopTimeout;
    }

    public void setStopTimeout(long stopTimeout) {
        this._stopTimeout = stopTimeout;
    }


}
