package king.consierd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul 路由网关
 * 		pom:	spring-cloud-starter-zuul
 * 				spring-cloud-starter-eureka
 * 				spring-boot-starter-web
 * 		anno:	@EnableEurekaClient
 * 				@EnableZuulProxy
 * 		yml: 	配置转发规则
 *
 * zuul 服务过滤
 * 		定义 filter 继承 ZuulFilter 类, 注入到 ioc 容器
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}
}
