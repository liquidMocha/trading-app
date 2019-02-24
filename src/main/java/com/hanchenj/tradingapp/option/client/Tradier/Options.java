
package com.hanchenj.tradingapp.option.client.Tradier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
class Options {

    @JsonProperty("option")
    private List<Option> options;

    List<com.hanchenj.tradingapp.option.domain.Option> transformToDomainOptions() {
        return options.stream().map(theOption -> new com.hanchenj.tradingapp.option.domain.Option(
                theOption.getAsk(),
                theOption.getBid(),
                theOption.getChange(),
                theOption.getChangePercentage(),
                theOption.getClose(),
                theOption.getExpirationDate(),
                theOption.getExpirationType(),
                theOption.getLast(),
                theOption.getOpen(),
                theOption.getOpenInterest(),
                theOption.getOptionType(),
                theOption.getPrevclose(),
                theOption.getRootSymbol(),
                theOption.getStrike(),
                theOption.getSymbol(),
                theOption.getTradeDate(),
                theOption.getType(),
                theOption.getUnderlying())).collect(Collectors.toList());
    }
}
