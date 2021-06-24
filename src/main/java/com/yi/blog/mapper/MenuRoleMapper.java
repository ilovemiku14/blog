package com.yi.blog.mapper;

import com.yi.blog.pojo.RespBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MenuRoleMapper {
    List<Integer> getMidByRid(int rid);

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    Integer updateMenuRole(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
    boolean delectMenuRole(Integer rid);

}
