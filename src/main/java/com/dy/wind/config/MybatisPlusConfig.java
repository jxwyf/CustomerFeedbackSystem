package com.dy.wind.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hasee
 */
@Configuration
@MapperScan("com/dy/wind/mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     * @data: 2021/7/17-15:13
     * @method: paginationInterceptor
     * @params: []
     * @return: com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * 自以为没人知道的小心思，实际上是明目张胆
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
