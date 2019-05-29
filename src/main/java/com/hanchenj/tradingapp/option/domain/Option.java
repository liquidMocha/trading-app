
package com.hanchenj.tradingapp.option.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Option {
    private Double ask;
    private Double bid;
    private LocalDate expirationDate;
    private String expirationType;
    private String rootSymbol;
    private Long strike;
    private String symbol;
    private Long tradeDate;
    private String underlying;
}
