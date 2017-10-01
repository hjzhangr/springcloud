package king.consierd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 * 	 pom: spring-cloud-starter-eureka-server
 * 	 anno: @EnableEurekaServer
 * 	 yml: eureka.client.registerWithEureka: false	指定 server
 *		  eureka.client.fetchRegistry: false		指定 server
 *
 * 每一个实例注册之后需要向注册中心发送心跳, 在默认情况下erureka server也是一个eureka client
 * 必须要在配置文件中指定一个 server
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
