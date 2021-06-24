package com.yi.blog.service;

import com.yi.blog.pojo.Timeaxis;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public interface TimeaxisService {
    List<Timeaxis> selectAll();
    boolean detectTimeaxis(int uid);
    boolean updateTimeaxis(Timeaxis Timeaxis);
    boolean addTimeaxis(Timeaxis Timeaxis);
    Integer selectAllCount();
}
