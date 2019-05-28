
package com.hanchenj.tradingapp.option.client.Tradier;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.Collections.emptyList;

@Data
@Slf4j
class TradierOptionChainResponse {
    private Options options;

    List<com.hanchenj.tradingapp.option.domain.Option> transformToOptions() {
        if (this.options != null) {
            log.info("Tradier returned Options: " + this.options.toString());
            return this.options.transformToDomainOptions();
        }

        return emptyList();
    }
}
