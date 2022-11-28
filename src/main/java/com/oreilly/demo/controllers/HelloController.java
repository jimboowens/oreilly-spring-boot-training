package com.oreilly.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    // where is the model fed in? There is no need to do it; the @Controller (discovered by
    // @ApplicationScoped->@ComponentScan Annotation) will feed in a Model from the Application Context.
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("user",name);
        return "hello"; // look for hello.html in resources>templates
    }
}
