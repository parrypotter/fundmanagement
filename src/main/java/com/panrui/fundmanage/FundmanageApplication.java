package com.panrui.fundmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.panrui.fundmanage.mapper")
@SpringBootApplication
public class FundmanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundmanageApplication.class, args);
	}

}
