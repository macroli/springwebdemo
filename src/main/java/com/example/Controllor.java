package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by v-macli on 2/14/2016.
 */
@Controller
public class Controllor {

    @RequestMapping("/index")
    public String greeting() {
        return "index";
    }
}
