package demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import demo.dao.OfferClient;
import demo.dao.ArticleClient;
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
	ArticleClient articleClient;
	@Autowired
	OfferClient offerClient;
	@Autowired
	ProductClient productClient;
	
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public Word getCustomer() {
		return customerClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackGeneric")
	public Word getPayment() {
		return paymentClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackGeneric")
	public Word getArticle() {
		return articleClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackGeneric")
	public Word getOffer() {
		return offerClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackGeneric")
	public Word getProduct() {
		return productClient.getWord();
	}	

	public Word getFallbackSubject() {
		return new Word("Someone");
	}

	public Word getFallbackGeneric() {
		return new Word("Unknown");
	}

}
