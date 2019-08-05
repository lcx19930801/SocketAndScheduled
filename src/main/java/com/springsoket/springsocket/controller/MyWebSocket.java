package com.springsoket.springsocket.controller;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;


@Component
@ServerEndpoint(value = "/myWebSocket/{nickname}")
public class MyWebSocket {

    //用来存放每个客户端对应的MyWebSocket对象
    private static CopyOnWriteArraySet<MyWebSocket> user = new CopyOnWriteArraySet<MyWebSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private  String nickname;
    @OnMessage
    public void onMessage(String message, Session session,@PathParam("nickname")String nickname) throws IOException {

        //群发消息
        for (MyWebSocket myWebSocket : user) {
            myWebSocket.session.getBasicRemote().sendText(nickname+"："+message);
            //myWebSocket.session.getBasicRemote().sendText("<img src=''/>");
        }

    }

    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname){
        System.out.println(session.getId()+" open...");
        this.session = session;
        this.nickname = nickname;
        user.add(this);
        System.out.println("有新连接加入:"+nickname+"当前在线人数为" + user.size());
        this.session.getAsyncRemote().sendText("恭喜您成功连接上WebSocket-->当前在线人数"+user.size());
    }
    @OnClose
    public void onClose(){
        System.out.println("有一连接关闭！当前在线人数为" + user.size());
        user.remove(this);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println(this.session.getId() + " error...");
        error.printStackTrace();
    }

}
