package com.example.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichuang
 * @date 2022/10/21
 */
@RestController
@Slf4j
public class ActionController {

    @GetMapping("/idx")
    public String idx() {
        return "idx";
    }
}
