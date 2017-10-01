package king.consierd.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义 feign 接口, 用 @FeignClient 注解指定要调用的服务
 * 使用 @RequestMapping 注解指定要调用服务的路径
 *
 * @author 张红杰 13022800618
 * @version 1.0, 2017.10.1 8:39
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiImpl.class)
public interface SchedualServiceHi {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam("name") String name);

}
