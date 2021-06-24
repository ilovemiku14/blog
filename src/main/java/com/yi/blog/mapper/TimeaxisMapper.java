package com.yi.blog.mapper;

import com.yi.blog.pojo.Timeaxis;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface TimeaxisMapper {
    List<Timeaxis> selectAll();
    boolean detectTimeaxis(int uid);
    boolean updateTimeaxis(Timeaxis Timeaxis);
    boolean addTimeaxis(Timeaxis Timeaxis);
    Integer selectAllCount();
}
