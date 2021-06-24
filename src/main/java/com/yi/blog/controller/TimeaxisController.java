package com.yi.blog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.blog.lang.ResultCode;
import com.yi.blog.service.impl.TimeaxisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timeaxis")
@CrossOrigin(origins = "*",maxAge = 3600)//秒单位
public class TimeaxisController {

    @Autowired
    private TimeaxisServiceImpl timeaxisService;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ResultCode resultCode;
    @PostMapping("/timeaxisList")
    public String selectAll(){
        try {
            ResultCode resultCode = this.resultCode.such(200,"ok",timeaxisService.selectAll());
            String s = objectMapper.writeValueAsString(resultCode);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "400";
        }
    }
}
