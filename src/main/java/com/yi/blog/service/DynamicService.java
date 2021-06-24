package com.yi.blog.service;

import com.yi.blog.pojo.Dynamic;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public interface DynamicService {
    List<Dynamic> selectAll();
    boolean detectDynamic(int uid);
    boolean updateDynamic(Dynamic Dynamic);
    boolean addDynamic(Dynamic Dynamic);
    Integer selectAllCount();
}
