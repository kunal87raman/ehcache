package com.coursecube.ehcache.service;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

@Slf4j
public class CacheEventLogger implements CacheEventListener<Object,Object> {
    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        String eventTpe = cacheEvent.getType().name();
        log.info("Cache event {} for item with key {} Old value = {}, New value = {}",
                eventTpe, cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
