package me.guopop.springboot.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guopop
 * @date 2021/8/6 10:18
 */
@RestController
public class HiController {

    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }
}
