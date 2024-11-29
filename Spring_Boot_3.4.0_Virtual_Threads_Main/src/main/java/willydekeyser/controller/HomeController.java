package willydekeyser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class HomeController {

	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    private final RestClient  restClient;
    public HomeController(RestClient.Builder builder){
        this.restClient=builder.baseUrl("http://localhost:8091").build();
    }
    
    @GetMapping("/getDataSlow/{seconds}")
    public String home(@PathVariable Integer seconds){
        ResponseEntity<Void> result = restClient.get()
                .uri("/block/"+seconds)
                .retrieve()
                .toBodilessEntity();

        logger.info("{} on {}",result.getStatusCode(),Thread.currentThread());
        return Thread.currentThread().toString();

    }

}
