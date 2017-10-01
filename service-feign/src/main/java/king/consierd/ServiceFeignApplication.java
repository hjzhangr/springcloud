package king.consierd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * -- Feign 整合了 Ribbon , 使用基于接口的注解实现负载均衡
 * 	 	pom: 	spring-cloud-starter-feign
 * 	 			spring-cloud-starter-eureka
 * 	 			spring-boot-starter-web
 * 	 	anno:	@EnableDiscoveryClient
 * 	 			@EnableFeignClients
 * 	 	yml:	注册服务
 *
 * 	 	定义 feign 接口, 用 @FeignClient 注解指定要调用的服务
 *	 	使用 @RequestMapping 注解指定要调用服务的路径
 *
 * -- Feign 中使用断路器
 * 		feign 自带断路器, 直接打开
 * 		yml: 	feign.hystrix.enabled=true
 * 		code:	定义接口的实现类, 重写熔断方法, 用 @FeignClient 的 fallback 指定实现类
 *
 * -- 在 feign 中使用断路器仪表盘
 * 		pom:	spring-boot-starter-actuator
 * 				spring-cloud-starter-hystrix-dashboard
 * 				spring-cloud-starter-hystrix	**注意
 * 		anno:	@EnableHystrixDashboard
 * 				@EnableCircuitBreaker	**注意
 * 		path:	http://localhost:8764/hystrix
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFeignApplication.class, args);
	}
}
