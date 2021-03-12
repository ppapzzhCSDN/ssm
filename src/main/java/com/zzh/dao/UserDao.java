package com.zzh.dao;

import com.zzh.entity.User;
import com.zzh.qo.UserQo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author zzh
 * @description
 * @date
 */
@MapperScan
public interface UserDao {
    User getUserById(Integer id);

    int getCount(UserQo userQo);

    List<User> listAll(UserQo userQo);

    int add(User user);

    int delete(Integer id);

    User toUpdate(Integer id);

    int update(User user);

    //参数绑定
    List<User> checkUsernamePs(@Param("name") String name, @Param("password") String password);
}
