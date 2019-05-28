package com.hanchenj.tradingapp.option.controller;

import com.hanchenj.tradingapp.option.domain.Option;
import com.hanchenj.tradingapp.option.service.OptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "option")
public class OptionController {

    private OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping(value = "/{ticker}")
    public List<Option> getOptionChain(
            @PathVariable("ticker") String ticker,
            @RequestHeader("Authorization") String token
    ) {
        return optionService.getOptionChain(ticker, token);
    }

}
