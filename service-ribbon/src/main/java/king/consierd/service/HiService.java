package king.consierd.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 张红杰 13022800618
 * @version 1.0, 2017.9.30 20:25
 */
@Service
public class HiService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiError")
	public String sayHiService(String name) {
		return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
	}

	public String hiError(String name) {
		return "Hi, " + name + ", ERROR !";
	}

}
