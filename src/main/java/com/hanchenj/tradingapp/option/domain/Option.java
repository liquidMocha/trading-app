
package com.hanchenj.tradingapp.option.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Option {
    private Double ask;
    private Long bid;
    private Long change;
    private Long changePercentage;
    private Long close;
    private String expirationDate;
    private String expirationType;
    private Double last;
    private Long open;
    private Long openInterest;
    private String optionType;
    private Double prevclose;
    private String rootSymbol;
    private Long strike;
    private String symbol;
    private Long tradeDate;
    private String type;
    private String underlying;
}
