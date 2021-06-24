package com.yi.blog.service.impl;

import com.yi.blog.mapper.MenuRoleMapper;
import com.yi.blog.pojo.RespBean;
import com.yi.blog.service.MenuRoleService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MenuRoleServiceImpl implements MenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public List<Integer> getMidByRid(int rid) {
        return menuRoleMapper.getMidByRid(rid);
    }

    @Override
    @Transactional
    public Integer updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.delectMenuRole(rid);
        if (null == mids || 0==mids.length){
            return null;
        }
        return menuRoleMapper.updateMenuRole(rid, mids);
    }
}
