package com.openrum.collector.queue.impl;

import com.openrum.collector.exporter.DataWrapper;
import com.openrum.collector.queue.AbstractDataQueue;
import com.openrum.collector.queue.DataQueue;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description:
 * @author: lou renzheng
 * @create: 2022-12-30
 **/
public class LocalDataQueue<T> extends AbstractDataQueue<T> {

    private ArrayBlockingQueue<T> dataQueue;

    public LocalDataQueue(Integer size) {
        dataQueue = new ArrayBlockingQueue<>(size);
    }

    @Override
    public void put(T data) throws InterruptedException {
        dataQueue.put(data);
    }

    @Override
    public T poll() {
        return dataQueue.poll();
    }

    @Override
    public int size() {
        return dataQueue.size();
    }


    @Override
    public int drainTo(List<DataWrapper> c) {
        return dataQueue.drainTo((Collection<? super T>) c);
    }

    @Override
    public boolean isEmpty() {
        return dataQueue.isEmpty();
    }

}