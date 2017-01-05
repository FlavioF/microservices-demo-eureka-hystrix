package demo.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.domain.Ecommerce;

@FeignClient("PAYMENT")
public interface PaymentClient {

	@RequestMapping(value="/", method=RequestMethod.GET)
	Ecommerce getEcommerce();
	
}
