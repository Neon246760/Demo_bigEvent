package com.neon.demo_big_event.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neon.demo_big_event.common.Response;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Response<String> list() {
        return Response.success("所有文章数据...");
    }
    
}
