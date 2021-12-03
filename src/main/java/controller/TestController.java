package controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/")
    @ResponseBody
    public String test(){
        return "hello world";
    }


}
