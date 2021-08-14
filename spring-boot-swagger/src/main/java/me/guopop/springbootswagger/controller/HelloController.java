package me.guopop.springbootswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guopop
 * @date 2021/3/16 16:09
 */
@Api(tags = "hello功能")
@RestController
public class HelloController {

    @ApiOperation(value = "hello接口", notes = "描述")
    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
