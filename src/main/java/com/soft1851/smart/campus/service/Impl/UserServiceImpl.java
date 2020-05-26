package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.aspect.LogAspect;
import com.soft1851.smart.campus.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/26
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger Log = LoggerFactory.getLogger(LogAspect.class);

    @Override
    public String findUserName(String tel) {
        Log.info("tel:" + tel);
        return "wf";
    }
}
