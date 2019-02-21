package com.hanchenj.tradingapp.option.service;

import com.hanchenj.tradingapp.option.client.OptionInfoClient;
import com.hanchenj.tradingapp.option.domain.Option;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    private OptionInfoClient client;

    public OptionService(OptionInfoClient client){
        this.client = client;
    }

    List<Option> getOptionChain(String ticker){
        return client.getOptionChain(ticker);
    }
}
