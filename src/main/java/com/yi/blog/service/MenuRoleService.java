package com.yi.blog.service;

import com.yi.blog.pojo.RespBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuRoleService {
    List<Integer> getMidByRid(int rid);

    Integer updateMenuRole(Integer rid, Integer[] mids);
}
