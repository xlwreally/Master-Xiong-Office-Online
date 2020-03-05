package com.xlw.oa.service.safty.impl;

import com.xlw.oa.dao.safty.LoginDao;
import com.xlw.oa.service.safty.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/3 22:08
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao logindao;

    @Override
    public boolean check(String uid, String pwd) {
        return logindao.findById(uid, pwd);
    }
}
