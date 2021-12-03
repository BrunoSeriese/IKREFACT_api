package nl.hsleiden.authservices.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping()
    @ResponseBody
    String test(){
        return "hello world";
    }


}
