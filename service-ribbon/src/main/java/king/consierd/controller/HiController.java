package king.consierd.controller;

import king.consierd.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张红杰 13022800618
 * @version 1.0, 2017.9.30 20:25
 */
@RestController
public class HiController {

	@Autowired
	HiService hiService;

	@RequestMapping("/hi")
	public String sayHi(@RequestParam String name) {
		return hiService.sayHiService(name);
	}
}
