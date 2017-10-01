package king.consierd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * config client 从服务配置中心 config server 获取配置信息
 * config server 从远程仓库获取配置信息
 * 	 pom:	spring-cloud-starter-config
 * 	 		spring-boot-starter-web
 *   yml:	配置 config server 请求路径和配置信息文件名
 *
 *   -- 从已经注册到服务注册中心的 config-server 中读取配置文件内容
 *   	pom:	spring-cloud-starter-eureka
 *   	anno:	@EnableEurekaClient
 *   	yml:	将 spring.application.cloud.config.uri 更换为:
 *   			spring.application.cloud.config.discovery.enabled: true
 *   			spring.application.cloud.config.discovery.serviceId: config-server
 *   			再指定服务注册中心的地址 defaultZone
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String value;

	@Value("${foo2}")
	String value2;

	@RequestMapping("/hi")
	public String getConfig() {
		return value + value2;
	}
}
