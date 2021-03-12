package com.zzh.controller;

import com.zzh.constants.SysConstant;
import com.zzh.utils.ImgCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @author zzh
 * @description
 * @date
 */
@Controller
@RequestMapping("/pic")
public class PicController {
    @RequestMapping(value = "/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImgCodeUtil imgCodeUtil = new ImgCodeUtil();
        BufferedImage image = imgCodeUtil.getImage();

        String code = imgCodeUtil.getText();
        request.getSession().setAttribute(SysConstant.SESSION_CODE, code);

        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);

    }
}
