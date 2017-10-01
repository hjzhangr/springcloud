package king.consierd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * config client 从服务配置中心 config server 获取配置信息
 * config server 从远程仓库获取配置信息
 * 	 pom:	spring-cloud-starter-config
 * 	 		spring-boot-starter-web
 *   yml:	配置 config server 请求路径和配置信息文件名
 */
@SpringBootApplication
@RestController
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
