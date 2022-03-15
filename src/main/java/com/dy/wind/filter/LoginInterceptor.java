package com.dy.wind.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.dy.wind.config.VerifyToken;
import com.dy.wind.entity.DyUser;
import com.dy.wind.exception.DyException;
import com.dy.wind.mapper.DyUserMapper;
import com.dy.wind.result.ResultCodeEnum;
import com.dy.wind.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private DyUserMapper dyUserMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //不是映射到controller的方法直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查不需要验证token的
        if (method.isAnnotationPresent(VerifyToken.class)) {
            VerifyToken annotation = method.getAnnotation(VerifyToken.class);
            String token = request.getHeader("token");
            if (annotation.required()){
                if (token == null) {
                    throw new DyException(ResultCodeEnum.LOGIN_ACL);
                }
                //获取token中的uuid
                String uuid;
                try {
                    uuid = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException e) {
                    throw new RuntimeException("没有uuid");
                }
                DyUser dyUser = dyUserMapper.selectById(uuid);
                if (dyUser == null) {
                    throw new DyException(ResultCodeEnum.LOGIN_ACL);
                }
                Map<String, Object> checkToken = JwtUtils.checkToken(token);
                if (checkToken == null) {
                    throw new RuntimeException("token验证失败");
                }
                return true;
            }
        }
        return true;
    }
}
