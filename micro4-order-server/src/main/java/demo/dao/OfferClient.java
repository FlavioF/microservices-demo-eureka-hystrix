package demo.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.domain.Ecommerce;

@FeignClient("OFFER")
public interface OfferClient {

	@RequestMapping(value="/", method=RequestMethod.GET)
	Ecommerce getEcommerce();
	
}
