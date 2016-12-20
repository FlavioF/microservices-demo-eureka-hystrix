package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.service.OrderService;



@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	
	/**
	 * Display a small list of Sentences to the caller:
	 */
	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
		long start = System.currentTimeMillis();
		String output = 
			"<h1>Happy Meals at MacDonalds</h1><br/>" +
			orderService.buildSentence() + "<br/><br/>" +
			orderService.buildSentence() + "<br/><br/>" +
			orderService.buildSentence() + "<br/><br/>" +
			orderService.buildSentence() + "<br/><br/>" +
			orderService.buildSentence() + "<br/><br/>" +
			"<img src='http://www.nogarlicnoonions.com/images/uploads/NEWS/Mcdonalds.jpg' width=533 height=300>";
		long end = System.currentTimeMillis();
		return output + "<br><hr><font size=small>Elapsed time (ms): " + (end - start) + "</font>";
	}

}
