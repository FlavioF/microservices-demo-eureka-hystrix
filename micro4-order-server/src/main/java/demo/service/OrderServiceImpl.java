package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Build a order by assembling randomly generated products, articles,
 * customers, offers, and payments.  The individual parts of speech will
 * be obtained by calling the various DAOs.
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	EcommerceService ecommerceService;
	

	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	public String build() {
		return  
			String.format("%s %s %s %s %s %s.",
				ecommerceService.getCustomer().getString(),
				"bought",
				ecommerceService.getProduct().getString(),
				ecommerceService.getPayment().getString(),
				ecommerceService.getPurchase().getString(),
				ecommerceService.getOffer().getString())
			;
	}	
}
