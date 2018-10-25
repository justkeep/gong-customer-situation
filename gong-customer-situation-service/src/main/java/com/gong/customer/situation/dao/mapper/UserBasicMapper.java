package com.gong.customer.situation.dao.mapper;

import com.gong.customer.situation.domain.UserBasic;
import com.gong.customer.situation.domain.UserBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBasicMapper {
    int countByExample(UserBasicExample example);

    int deleteByExample(UserBasicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserBasic record);

    int insertSelective(UserBasic record);

    List<UserBasic> selectByExample(UserBasicExample example);

    UserBasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserBasic record, @Param("example") UserBasicExample example);

    int updateByExample(@Param("record") UserBasic record, @Param("example") UserBasicExample example);

    int updateByPrimaryKeySelective(UserBasic record);

    int updateByPrimaryKey(UserBasic record);
}