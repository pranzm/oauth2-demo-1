package owsap.dependency.demo.pranjal.oauth2demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String publicPage(){
        return "<h5>This is Public Page</h5>";
    }

    @GetMapping("/private")
    public String privatePage(){
        return "<h5>Private Space</h5>";
    }

}
