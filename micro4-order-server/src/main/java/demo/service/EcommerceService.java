package demo.service;

import demo.domain.Ecommerce;

public interface EcommerceService {

	Ecommerce getCustomer();
	Ecommerce getPayment();
	Ecommerce getPurchase();
	Ecommerce getOffer();
	Ecommerce getProduct();

}
