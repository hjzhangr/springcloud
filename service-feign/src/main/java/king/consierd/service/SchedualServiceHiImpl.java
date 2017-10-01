package king.consierd.service;

import org.springframework.stereotype.Component;

/**
 * @author 张红杰 13022800618
 * @version 1.0, 2017.10.1 9:37
 */
@Component
public class SchedualServiceHiImpl implements SchedualServiceHi {

	@Override
	public String sayHiFromClientOne(String name) {
		return "Hi, " + name + ", ERROR !";
	}
}
