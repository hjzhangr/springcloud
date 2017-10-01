package king.consierd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者:
 * 	 pom: 	spring-cloud-starter-eureka,
 * 	 		spring-boot-starter-web
 * 	 anno: 	@EnableEurekaClient
 */
@SpringBootApplication
@EnableEurekaClient
@RestController		// 等效于@Controller + @Responsebody
public class EurekaClient01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient01Application.class, args);
	}

	@Value("${server.port}")
	String port;		// 从配置文件中获取端口号

	@RequestMapping("/hi")
	public String sayHi(@RequestParam String name) {
		return "Hello, I'm " + name + ", from " + port + "!";
	}



}
