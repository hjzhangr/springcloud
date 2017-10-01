package king.consierd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * -- ribbon是一个负载均衡客户端
 * 	 	eureka-client01和eureka-client02注册的服务名称都是service-hi
 * 	 	service-hi的两个实例相当于一个小的集群, 通过service-ribbon实现集群的负载均衡
 * 		pom: 	spring-cloud-starter-eureka
 * 	 			spring-cloud-starter-ribbon
 * 	 			spring-boot-starter-web
 * 		anno: 	@EnableDiscoveryClient
 * 	 	yml:	..
 * 	 	code:	向 spring 容器注入一个 RestTemplate, 通过 @LoadBalance 注解实现负载均衡
 *
 * -- 在 ribbon 中使用断路器
 * 	 	pom: 	spring-cloud-starter-hystrix
 * 	 	anno: 	@EnableHystrix
 *   	code:	在 service 方法上添加 @HystrixCommand 指定 fallback 熔断方法
 *
 * -- 在 ribbon 中使用断路器仪表盘
 * 		pom:	spring-boot-starter-actuator
 * 				spring-cloud-starter-hystrix-dashboard
 * 		anno:	@EnableHystrixDashboard
 * 		path:	http://localhost:8764/hystrix
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
