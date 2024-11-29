package willydekeyser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	
	@GetMapping("/block/{seconds}")
    public void getSlowData(@PathVariable Integer seconds) throws InterruptedException{
        Thread.sleep(seconds*1000);
        log.info("Sleep for {} seconds ",seconds);
    }
}
