package escuelaing.edu.co.math.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.co.math.ProxyRoundRobin;
import escuelaing.edu.co.math.services.MathService;
import java.util.List;
import java.util.Map;

@RestController
public class ProxyController {
    
    ProxyRoundRobin proxyRoundRobin;

    @Autowired
    public ProxyController(ProxyRoundRobin proxyRoundRobin) {
        this.proxyRoundRobin = proxyRoundRobin;
    }

    @PostMapping("/proxy/linearSearch")
    public String linealSearch(@RequestParam("list") String list, @RequestParam("value") int value) {
        String path = "/linearSearch?list=" + list + "&value=" + value;
        try{
            return proxyRoundRobin.sendRequest(path);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/proxy/binarySearch")
    public String binarySearch(@RequestParam("list") String list, @RequestParam("value") int value) {
        String path = "/binarySearch?list=" + list + "&value=" + value;
        try{
            return proxyRoundRobin.sendRequest(path);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
}
