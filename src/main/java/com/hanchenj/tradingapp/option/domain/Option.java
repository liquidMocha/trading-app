
package com.hanchenj.tradingapp.option.domain;

import lombok.Data;

@Data
public class Option {

    private Double ask;
    private Long askDate;
    private String askexch;
    private Long asksize;
    private Long averageVolume;
    private Long bid;
    private Long bidDate;
    private String bidexch;
    private Long bidsize;
    private Long change;
    private Long changePercentage;
    private Long close;
    private Long contractSize;
    private String description;
    private String expirationDate;
    private String expirationType;
    private Long high;
    private Double last;
    private Long lastVolume;
    private Long low;
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
    private Long volume;
    private Long week52High;
    private Long week52Low;
}
