package king.consierd.controller;

import king.consierd.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用 SchedualServiceHi 接口
 *
 * @author 张红杰 13022800618
 * @version 1.0, 2017.10.1 8:43
 */
@RestController
public class HiControllerFeign {

	@Autowired
	private SchedualServiceHi schedualServiceHi;

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String feignSayHiFromClient(@RequestParam String name) {
		return schedualServiceHi.sayHiFromClientOne(name);
	}

}
