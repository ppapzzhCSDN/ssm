package com.zzh.controller;

import com.zzh.constants.SysConstant;
import com.zzh.entity.User;
import com.zzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zzh
 * @description
 * @date
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String name, String password, String code, ModelAndView mav, HttpServletRequest request) {
        mav.setViewName("redirect:/user/listAll");

        Object obj = request.getSession().getAttribute(SysConstant.SESSION_CODE);
        System.out.println("session中的验证码：" + obj.toString());
        if (!(obj != null && code.equalsIgnoreCase(obj.toString()))) {
            mav.setViewName("redirect:/index.jsp");
            return mav;
        }

        List<User> list = userService.checkUsernamePs(name,password);
        if (list == null || list.size() != 1) {
            mav.setViewName("redirect:/index.jsp");
        }

        User user = list.get(0);
        HttpSession session = request.getSession();
        session.setAttribute(SysConstant.SESSION_LOGIN, user);

        return mav;
    }
}
