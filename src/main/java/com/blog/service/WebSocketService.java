package com.blog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author huangfu
 */
@Component
@ServerEndpoint("/webSocket")
public class WebSocketService {
    private static final Logger LOGGER =  LoggerFactory.getLogger(WebSocketService.class);
    private Session session;
    private static CopyOnWriteArraySet<WebSocketService> webSockets;
    static {
        webSockets = new CopyOnWriteArraySet<WebSocketService>();
    }

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);
        LOGGER.info("【websock消息】，有新的连接，连接总数={}" , webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        LOGGER.info("【websock消息】，有连接断开，连接总数={}" , webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        LOGGER.info("【websock消息】，收到新的消息，msg={}" , message);
    }

    public void sendMessage(String message) {
        for(WebSocketService webSocket : webSockets) {
            LOGGER.info("【websock消息】广播消息");
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                LOGGER.error("【websock消息】，广播消息失败，e={}" , e);
            }
        }
    }
}
