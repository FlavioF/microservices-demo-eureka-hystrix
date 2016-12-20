package demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import demo.dao.OfferClient;
import demo.dao.PurchaseClient;
import demo.dao.ProductClient;
import demo.dao.CustomerClient;
import demo.dao.PaymentClient;
import demo.domain.Word;

@Service
public class WordServiceImpl implements WordService {

	@Autowired
	PaymentClient paymentClient;
	@Autowired
    CustomerClient customerClient;
	@Autowired
    PurchaseClient purchaseClient;
	@Autowired
	OfferClient offerClient;
	@Autowired
	ProductClient productClient;
	
	
	@Override
	@HystrixCommand(fallbackMethod="getCustomerFallback")
	public Word getCustomer() {
		return customerClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getPaymentFallback")
	public Word getPayment() {
		return paymentClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getPurchaseFallback")
	public Word getPurchase() {
		return purchaseClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getOfferFallback")
	public Word getOffer() {
		return offerClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getProductFallback")
	public Word getProduct() {
		return productClient.getWord();
	}	

	public Word getCustomerFallback() {
		return new Word("Pras_Biswas");
	}

	public Word getPaymentFallback() {
		return new Word("Paid_by_Cash");
	}

	public Word getPurchaseFallback() {
		return new Word("Paid_for_and_got_free");
	}

	public Word getOfferFallback() {
		return new Word("Free_Fries");
	}

	public Word getProductFallback() {
		return new Word("BigMac");
	}


}
