package cn.ekgc.ums;

import org.hibernate.validator.internal.constraintvalidators.bv.number.bound.AbstractMinValidator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>UMS Provider 启动器</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@EnableEurekaClient
@MapperScan("cn.ekgc.ums.dao")
@SpringBootApplication
public class UmsProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(UmsProviderStarter.class, args);
	}
}
