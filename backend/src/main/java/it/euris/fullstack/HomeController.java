package it.euris.fullstack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/test")
    @ResponseBody
    String home() {
	return "TEST";
    }

}
