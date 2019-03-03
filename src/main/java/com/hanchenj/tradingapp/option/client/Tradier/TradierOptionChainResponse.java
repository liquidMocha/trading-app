
package com.hanchenj.tradingapp.option.client.Tradier;

import lombok.Data;

import java.util.List;

import static java.util.Collections.emptyList;

@Data
class TradierOptionChainResponse {
    private Options options;

    List<com.hanchenj.tradingapp.option.domain.Option> transformToOptions() {
        if (this.options != null) {
            return this.options.transformToDomainOptions();
        }

        return emptyList();
    }
}
