package cn.ekgc.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>注册中心启动器</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class UmsRegisterStarter {
	public static void main(String[] args) {
		SpringApplication.run(UmsRegisterStarter.class, args);
	}
}
