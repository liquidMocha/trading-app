package com.hanchenj.tradingapp.option.controller;

import com.hanchenj.tradingapp.option.domain.Option;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionController {
    @GetMapping(value = "/")
    public Option hello(){
        return new Option();
    }

}
