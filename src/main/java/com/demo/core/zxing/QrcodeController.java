package com.demo.core.zxing;

import com.google.zxing.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: jiafengjie
 * @Date: 2019-05-22 14:54
 * @Version 1.0
 */
@RestController
public class QrcodeController {

    @RequestMapping("/productcode")
    public void productcode() {

        com.whyhow.util.QRCodeUtil.zxingCodeCreate("http://www.runoob.com/html/html-images.html", "L:\\cc.jpg",500,"C:\\Users\\LMS\\Desktop\\img\\0101.jpg");
    }
    @RequestMapping("/test")
    public String test() {

        return "dddddddddd";
        }

    @RequestMapping("/analysiscode")
    public void analysiscode() {

        Result result = com.whyhow.util.QRCodeUtil.zxingCodeAnalyze("L:\\aa.jpg");
        System.err.println("二维码解析内容："+result.toString());
    }
    @RequestMapping("/getimg")
    public void analysiscode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        //生成二维码图片
       // BufferedImage bufImage = QRCodeUtil.getBufferedImage("https://www.baidu.com/", null,"/Users/jiafengjie/Pictures/timg.jpeg");
         BufferedImage bufImage = com.whyhow.util.QRCodeUtil.getBufferedImage("https://www.baidu.com/", null,"");



        //直接打开图片
        resp.setContentType("image/jpg");
        //直接下载图片
//		resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("cc.jpg", "UTF-8"));
        //将图片写出到浏览器
        OutputStream out = resp.getOutputStream();
        ImageIO.write(bufImage, "jpg", out);
        out.close();
    }

}

