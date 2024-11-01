package com.ssafy.pjt_B.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.pjt_B.mvc.model.dao")
public class DBConfig {

}
