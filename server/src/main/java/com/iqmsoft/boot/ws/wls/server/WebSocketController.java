package com.iqmsoft.boot.ws.wls.server;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.SpringConfigurator;

@Component
@ServerEndpoint(value = "/atom/gwidgets-ws", configurator = SpringConfigurator.class)
public class WebSocketController {
 
    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {

    	System.out.println("Message ");
        session.getBasicRemote().sendText(
                "Reversed: " + new StringBuilder(message).reverse());
    }

    @OnOpen
    public void onOpen(Session session) {
      
        System.out.println("New client @"+session.getId());
       
    }

    @OnClose
    public void onClose(Session session) {
        
        System.out.println("Client disconnected @" + session.getId());
    }
}