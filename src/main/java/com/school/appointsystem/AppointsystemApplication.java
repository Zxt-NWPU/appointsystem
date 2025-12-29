package com.school.appointsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.school.appointsystem.mapper") // 扫描当前包下的Mapper接口
public class AppointsystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppointsystemApplication.class, args);
	}
}
