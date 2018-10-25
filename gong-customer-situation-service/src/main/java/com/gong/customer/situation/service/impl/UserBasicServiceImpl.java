package com.gong.customer.situation.service.impl;

import com.gong.customer.situation.dao.repository.UserBasicDao;
import com.gong.customer.situation.domain.UserBasic;
import com.gong.customer.situation.service.UserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 59448 on 2018/10/25.
 */
@Service("userBasicService")
public class UserBasicServiceImpl implements UserBasicService {
    @Autowired
    private UserBasicDao userBasicDao;
    @Override
    public List<UserBasic> searchUserBasic() {
        return userBasicDao.searchUserBasic();
    }
}
