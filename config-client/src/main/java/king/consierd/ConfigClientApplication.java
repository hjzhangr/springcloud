package king.consierd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * config client 从服务配置中心 config server 获取配置信息
 * 	 pom:	spring-cloud-starter-config
 * 	 		spring-boot-starter-web
 *   prop:	配置 config server 信息
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${server.port}")
	String value;

	@RequestMapping("/hi")
	public String getConfig() {
		return value;
	}
}
