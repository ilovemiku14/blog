package com.yi.blog.service.impl;

import com.yi.blog.mapper.TimeaxisMapper;
import com.yi.blog.pojo.Timeaxis;
import com.yi.blog.service.TimeaxisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class TimeaxisServiceImpl implements TimeaxisService {
    @Autowired
    private TimeaxisMapper timeaxisMapper;
    @Override
    public List<Timeaxis> selectAll() {
        return timeaxisMapper.selectAll();
    }

    @Override
    public boolean detectTimeaxis(int uid) {
        return timeaxisMapper.detectTimeaxis(uid);
    }

    @Override
    public boolean updateTimeaxis(Timeaxis Timeaxis) {
        return timeaxisMapper.updateTimeaxis(Timeaxis);
    }

    @Override
    public boolean addTimeaxis(Timeaxis Timeaxis) {
        return timeaxisMapper.addTimeaxis(Timeaxis);
    }

    @Override
    public Integer selectAllCount() {
        return timeaxisMapper.selectAllCount();
    }
}
