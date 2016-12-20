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

	@Autowired WordService wordService;
	

	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	public String buildSentence() {
		return  
			String.format("%s %s %s %s %s %s.",
				wordService.getCustomer().getString(),
				"bought",
				wordService.getProduct().getString(),
				wordService.getPayment().getString(),
				wordService.getArticle().getString(),
				wordService.getOffer().getString())
			;
	}	
}
