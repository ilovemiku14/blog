package com.yi.blog.service.impl;

import com.yi.blog.mapper.DynamicMapper;
import com.yi.blog.pojo.Dynamic;
import com.yi.blog.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Override
    public List<Dynamic> selectAll() {
        return dynamicMapper.selectAll();
    }

    @Override
    public boolean detectDynamic(int uid) {
        return dynamicMapper.detectDynamic(uid);
    }

    @Override
    public boolean updateDynamic(Dynamic Dynamic) {
        return dynamicMapper.updateDynamic(Dynamic);
    }

    @Override
    public boolean addDynamic(Dynamic Dynamic) {
        return dynamicMapper.addDynamic(Dynamic);
    }

    @Override
    public Integer selectAllCount() {
        return dynamicMapper.selectAllCount();
    }
}
