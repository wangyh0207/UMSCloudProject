package cn.ekgc.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>UMS Consumer 启动器</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class UmsConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(UmsConsumerStarter.class, args);
	}
}
