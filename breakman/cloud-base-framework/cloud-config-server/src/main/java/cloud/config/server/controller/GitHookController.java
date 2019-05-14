package cloud.config.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 *
 *
 * @author jinchuang
 * @date 2017/4/13
 */
@RestController
public class GitHookController {



    @GetMapping("/hook")
    public void hook(String destination){

        HashMap<String,String> request = null;
      /*  if (null != destination){
            request = new HashMap<>(1);
            request.put("destination",destination);
        }*/
       // String result = restTemplate.postForObject("http://localhost:9988/bus/refresh",request,String.class);
        System.out.println("1111111111111");


    }
}
