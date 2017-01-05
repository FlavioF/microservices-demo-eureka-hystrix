package demo.service;


import demo.domain.Ecommerce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import demo.dao.OfferClient;
import demo.dao.PurchaseClient;
import demo.dao.ProductClient;
import demo.dao.CustomerClient;
import demo.dao.PaymentClient;

@Service
public class EcommerceServiceImpl implements EcommerceService {

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
	public Ecommerce getCustomer() {
		return customerClient.getEcommerce();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getPaymentFallback")
	public Ecommerce getPayment() {
		return paymentClient.getEcommerce();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getPurchaseFallback")
	public Ecommerce getPurchase() {
		return purchaseClient.getEcommerce();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getOfferFallback")
	public Ecommerce getOffer() {
		return offerClient.getEcommerce();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getProductFallback")
	public Ecommerce getProduct() {
		return productClient.getEcommerce();
	}	

	public Ecommerce getCustomerFallback() {
		return new Ecommerce("Pras_Biswas");
	}

	public Ecommerce getPaymentFallback() {
		return new Ecommerce("Paid_by_Cash");
	}

	public Ecommerce getPurchaseFallback() {
		return new Ecommerce("Paid_for_and_got_free");
	}

	public Ecommerce getOfferFallback() {
		return new Ecommerce("Free_Fries");
	}

	public Ecommerce getProductFallback() {
		return new Ecommerce("BigMac");
	}


}
