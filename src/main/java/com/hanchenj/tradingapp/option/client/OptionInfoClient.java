package com.hanchenj.tradingapp.option.client;

import com.hanchenj.tradingapp.option.domain.Option;

import java.util.List;

public interface OptionInfoClient {
    List<Option> getOptionChain(String ticker);
}
