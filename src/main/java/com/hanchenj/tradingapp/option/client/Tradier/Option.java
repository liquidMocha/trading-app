
package com.hanchenj.tradingapp.option.client.Tradier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Option {

    @JsonProperty
    private Double ask;
    @JsonProperty
    private Long askDate;
    @JsonProperty
    private String askexch;
    @JsonProperty
    private Long asksize;
    @JsonProperty
    private Long averageVolume;
    @JsonProperty
    @Builder.Default
    private Long bid = 0L;
    @JsonProperty
    private Long bidDate;
    @JsonProperty
    private String bidexch;
    @JsonProperty
    private Long bidsize;
    @JsonProperty
    private Long change;
    @JsonProperty
    private Long changePercentage;
    @JsonProperty
    private Long close;
    @JsonProperty
    private Long contractSize;
    @JsonProperty
    private String description;
    @JsonProperty
    private String exch;
    @JsonProperty
    private String expirationDate;
    @JsonProperty
    private String expirationType;
    @JsonProperty
    private Long high;
    @JsonProperty
    private Double last;
    @JsonProperty
    private Long lastVolume;
    @JsonProperty
    private Long low;
    @JsonProperty
    private Long open;
    @JsonProperty
    private Long openInterest;
    @JsonProperty
    private String optionType;
    @JsonProperty
    private Double prevclose;
    @JsonProperty
    private String rootSymbol;
    @JsonProperty
    private Long strike;
    @JsonProperty
    private String symbol;
    @JsonProperty
    private Long tradeDate;
    @JsonProperty
    private String type;
    @JsonProperty
    private String underlying;
    @JsonProperty
    private Long volume;
    @JsonProperty
    private Long week52High;
    @JsonProperty
    private Long week52Low;
}
