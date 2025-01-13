package com.wyy.demoshiro.adapter;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;


public class CustomSessionListener extends SessionListenerAdapter {

    @Override
    public void onExpiration(Session session) {
        // 处理会话过期事件
        System.out.println("Session expired: " + session.getId());
    }

    @Override
    public void onStop(Session session) {
        // 处理会话停止事件
        System.out.println("Session stopped: " + session.getId());
    }
}
