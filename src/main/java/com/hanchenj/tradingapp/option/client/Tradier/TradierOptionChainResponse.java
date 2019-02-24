
package com.hanchenj.tradingapp.option.client.Tradier;

import lombok.Data;

import java.util.List;

@Data
class TradierOptionChainResponse {
    private Options options;

    List<com.hanchenj.tradingapp.option.domain.Option> transformToOptions() {
        return this.options.transformToDomainOptions();
    }
}
