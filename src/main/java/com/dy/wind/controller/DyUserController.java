package com.dy.wind.controller;

import com.dy.wind.config.UniqueUser;
import com.dy.wind.config.VerifyToken;
import com.dy.wind.entity.DyUser;
import com.dy.wind.result.Result;
import com.dy.wind.service.DyUserService;
import com.dy.wind.utils.JwtUtils;
import com.dy.wind.utils.ValidateCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Hasee
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping(value = "dy/feedback/user")
public class DyUserController {
    @Autowired
    private DyUserService dyUserService;

    /**
     * 添加用户
     * @data: 2021/12/27-11:23
     * @method: userInsert
     * @params: [username, password, area]
     * @return: com.dy.wind.result.Result
     */
    @ApiOperation(value = "注册用户")
    @PostMapping(value = "/insertUser")
    public Result userInsert(@UniqueUser @Valid @RequestBody DyUser dyUser){
        boolean insertUser = dyUserService.insertUser(dyUser);
        if (insertUser){
            return Result.ok("添加成功");
        }
        return Result.fail("存在相同用户名");
    }
    /**
     * @Description: 登录接口 
     * @Param: [username, password, request, response] 
     * @return: com.dy.wind.result.Result 
     * @Author: wind
     * @Date: 2022-03-02 22:41:05-
     **/
    @ApiOperation(value = "登录")
    @PostMapping(value = "/loginUser/")
    public Result loginUser(@Valid @RequestParam String username,
                            @Valid @RequestParam String password,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        String uuid = UUID.randomUUID().toString();
        boolean loginUser = dyUserService.loginUser(username, password);
        String token = JwtUtils.creatToken(uuid);
        if (loginUser) {
            request.setAttribute("token",token);
            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);
            return Result.ok("登录成功");
        }
        return Result.fail("用户名或者密码不正确");
    }
    @VerifyToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @ApiOperation(value = "返回验证码图片")
    @PostMapping("/getCaptchaImg")
    public void getCaptchaImg(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        try {

            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");
            ValidateCodeUtil validateCode = new ValidateCodeUtil();
            // getRandomCodeImage方法会直接将生成的验证码图片写入response
            validateCode.getRandomCodeImage(request, response);
            System.out.println("session里面存储的验证码为："+session.getAttribute("JCCODE"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "验证码校验")
    @PostMapping("/checkCaptcha")
    public boolean getCheckCaptcha(@RequestParam("code") String code, HttpSession session) {

        try {
            //toLowerCase() 不区分大小写进行验证码校验
            String sessionCode = String.valueOf(session.getAttribute("JCCODE")).toLowerCase();
            System.out.println("session里的验证码：" + sessionCode);
            String receivedCode = code.toLowerCase();
            System.out.println("用户的验证码：" + receivedCode);
            return !sessionCode.equals("") && !receivedCode.equals("") && sessionCode.equals(receivedCode);

        } catch (Exception e) {
            return false;
        }
    }

    @ApiOperation(value = "生成验证码,返回的是 base64")
    @PostMapping("/getCaptchaBase64")
    public Object getCaptchaBase64(HttpServletRequest request, HttpServletResponse response) {

        Map result = new HashMap();
        try {

            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");
            ValidateCodeUtil validateCode = new ValidateCodeUtil();
            // 返回base64
            String base64String = validateCode.getRandomCodeBase64(request, response);
            result.put("url", "data:image/png;base64," + base64String);
            result.put("message", "created successfull");
            //http://tool.chinaz.com/tools/imgtobase/  base64直接转为图片网站
            System.out.println("结果：" + result.get("url"));

        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }
}
