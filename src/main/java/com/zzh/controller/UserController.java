package com.zzh.controller;

import com.zzh.entity.User;
import com.zzh.qo.UserQo;
import com.zzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zzh
 * @description
 * @date
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "redirect:/user/listAll";
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public ModelAndView listAll(UserQo userQo,ModelAndView mal) {
        int count = userService.getCount(userQo);
        userQo.setCount(count);
        int page = userQo.getPage();
        if (page <= 1) {
            page = 1;
        }
        if (page >= userQo.getPageTotal()) {
            page = userQo.getPageTotal();
        }
        userQo.setPage(page);
        List<User> list = userService.listAll(userQo);
        //取代后缀.0
//        for (User u:list){
//            String createTime = u.getCreateTime();
//            String replace = createTime.replace(".0", "");
//            u.setCreateTime(replace);
//        }
        mal.addObject("list", list);
        mal.addObject("userQo",userQo);
        mal.setViewName("user/list");
        return mal;
    }

    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd(Model model) {
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(User user) {
        userService.add(user);
        ModelAndView mal = new ModelAndView();
        mal.setViewName("redirect:/user/listAll");
        return mal;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(Integer id) {
        int count = userService.delete(id);
        if (count == 1) {
            return "redirect:/user/listAll";
        }else {
            return "error";
        }
    }
    @RequestMapping(value = "toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(ModelAndView mal,Integer id) {
        User count = userService.toUpdate(id);
        mal.addObject("abc",count);
        mal.setViewName("user/update");
        return mal;
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView mal,User user) {
        userService.update(user);
        mal.setViewName("forward:/user/listAll");
        return mal;
    }


}
