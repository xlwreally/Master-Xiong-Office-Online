package com.xlw.oa.dao.safty;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/3 22:01
 */
@Repository
public interface LoginDao {
    @Select("select count(u_id) from t_user where u_id = #{uid} and u_pwd = #{upwd} and u_status = 1")
    boolean findById(@Param("uid") String userId, @Param("upwd") String userPwd);
}
