package com.oes.mapper;

import com.oes.entity.po.UserToken;
import org.apache.ibatis.annotations.Param;

/**
 * @author LongWei
 * @date 2025/6/4 10:58
 */
public interface UserTokenMapper {

    /**
     * insert
     * @param userToken
     */
    public void insertUserToken(@Param("userToken") UserToken userToken);


    public void updateUserToken(@Param("userToken") UserToken userToken);

}