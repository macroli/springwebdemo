package com.example;

import com.example.utils.LogAop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by v-macli on 2/14/2016.
 */
@Controller
public class Controllor {

    @RequestMapping("/index")
    public String greeting()
    {
        testAOP();
        return "index";
    }
    @LogAop(name="testAOP private")
    private void testAOP(){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            set.add(i);
        }
    }
}
