package com.gong.customer.situation.dao.repository;

import com.gong.customer.situation.dao.mapper.UserBasicMapper;
import com.gong.customer.situation.domain.UserBasic;
import com.gong.customer.situation.domain.UserBasicExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 59448 on 2018/10/25.
 */
@Repository
public class UserBasicDao {
    @Autowired
    private UserBasicMapper userBasicMapper;

    public List<UserBasic> searchUserBasic() {
        UserBasicExample userBasicExample = new UserBasicExample();
        userBasicExample.createCriteria()
                .andDeletedEqualTo(false);
        return userBasicMapper.selectByExample(userBasicExample);
    }
}
