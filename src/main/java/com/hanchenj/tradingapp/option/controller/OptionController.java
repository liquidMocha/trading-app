package com.hanchenj.tradingapp.option.controller;

import com.hanchenj.tradingapp.option.domain.Option;
import com.hanchenj.tradingapp.option.service.OptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OptionController {

    private OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping(value = "/")
    public List<Option> getOptionChain(
            @RequestParam("ticker") String ticker,
            @RequestHeader("Authorization") String token
    ) {
        return optionService.getOptionChain(ticker, token);
    }

}
