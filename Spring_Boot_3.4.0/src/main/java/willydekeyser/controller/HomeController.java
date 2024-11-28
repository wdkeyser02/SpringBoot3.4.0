package willydekeyser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String getHome() {
		
		logger.trace("Spring Boot Tutorial - Trace log.");
		logger.debug("Spring Boot Tutorial - Debug log.");
		logger.info("Spring Boot Tutorial - Info log.");
		logger.warn("Spring Boot Tutorial - This is a warning!");
		logger.error("Spring Boot Tutorial - We have an Error!");
		
		return "Spring Boot Tutorial";
	}
	

}
