package com.zzh.service;

import com.zzh.dao.UserDao;
import com.zzh.entity.User;
import com.zzh.qo.UserQo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zzh
 * @description
 * @date
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public List<User> listAll(UserQo userQo) {
        return userDao.listAll(userQo);
    }

    public int getCount(UserQo userQo) {
        return userDao.getCount(userQo);
    }

    public int add(User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        user.setCreateTime(sdf.format(new Date()));
        int count = userDao.add(user);
        return count;
    }

    public int delete(Integer id) {
        return userDao.delete(id);
    }

    public User toUpdate(Integer id) {
        return userDao.toUpdate(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

//      public  Boolean checkUsernamePs( String name, String password){
//       //返回name,password
//        List<User> list = userDao.checkUsernamePs(name, password);
//        if(list==null || list.size()!=-1 ){
//            return false;
//        }
//        return true;
//    }
    public List<User> checkUsernamePs(String name, String password) {
        return userDao.checkUsernamePs(name, password);
    }

}

