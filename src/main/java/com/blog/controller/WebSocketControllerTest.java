package com.blog.controller;

import com.blog.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSocketControllerTest {

    @Autowired
    private WebSocketService webSocketService;

    @RequestMapping("/ws")
    public ModelAndView SendAMessage(@RequestParam("msg") String msg){
        webSocketService.sendMessage(msg);
        return new ModelAndView("/test");
    }

    @RequestMapping("/test/test.html")
    public ModelAndView test(){
        return new ModelAndView("/test");
    }
    @RequestMapping("/websocket.html")
    public ModelAndView websocket(){
        return new ModelAndView("/websocket");
    }
}
