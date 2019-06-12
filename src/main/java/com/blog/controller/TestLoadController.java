package com.blog.controller;

import com.blog.service.SpikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class TestLoadController {
    //@Autowired
    @Resource
    private SpikeService spikeService;

    @GetMapping("query")
    public ModelAndView query(@RequestParam("productId") String productId, ModelAndView modelAndView){
        modelAndView.setViewName("/test1");
        modelAndView.addObject("productNum",spikeService.queryPriduct(productId));
        return modelAndView;
    }

    @GetMapping("order")
    public ModelAndView order(@RequestParam("productId") String productId,ModelAndView modelAndView){
        modelAndView.setViewName("/test1");
        spikeService.updateProduct(productId);
        modelAndView.addObject("productNum",spikeService.queryPriduct(productId));
        return modelAndView;
    }
}
