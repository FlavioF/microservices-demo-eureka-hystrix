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
	@RequestMapping("/order")
	public @ResponseBody String getSentence() {
		long start = System.currentTimeMillis();
		String output =
				"<h1>Happy Meals <img src='http://www.mcdonalds.co.uk/content/dam/McDonaldsUK/Food-category-header.png' width=200>at MacDonalds!</h1><br/><font color=navy size=4>" +
						orderService.build() + "!</font><br/><br/><font color=black size=6>" +
						orderService.build() + "!</font><br/><br/><font color=darkbrown size=5>" +
						orderService.build() + "!</font><br/><br/><font color=teal size=4>" +
						orderService.build() + "!</font><br/><br/><font color=orange size=6>" +
						orderService.build() + "!</font><br/><br/><img src='http://www.nogarlicnoonions.com/images/uploads/NEWS/Mcdonalds.jpg' width=533 height=300>";
		long end = System.currentTimeMillis();
		return output + "<br><hr><font size=small>Elapsed time (ms): " + (end - start) + "</font>";
	}

}
