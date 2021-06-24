package com.yi.blog.mapper;

import com.yi.blog.pojo.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@Mapper
public interface DynamicMapper {
    List<Dynamic> selectAll();
    boolean detectDynamic(int uid);
    boolean updateDynamic(Dynamic Dynamic);
    boolean addDynamic(Dynamic Dynamic);
    Integer selectAllCount();

}
