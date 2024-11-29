package willydekeyser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "<a href='/fast'>Get Data FAST</a><br><a href='/slow'>Get Data SLOW</a>";
	}
	
	@GetMapping("/fast")
	public String getDataFast() throws InterruptedException {
		Thread.sleep(1000);
		return "Spring Boot Tutorial - FAST";
	}
	
	@GetMapping("/slow")
	public String getDataSlow() throws InterruptedException {
		Thread.sleep(10000);
		return "Spring Boot Tutorial - SLOW";
	}
	
}
