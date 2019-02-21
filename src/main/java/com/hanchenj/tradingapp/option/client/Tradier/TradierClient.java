package com.hanchenj.tradingapp.option.client.Tradier;

import com.hanchenj.tradingapp.option.client.OptionInfoClient;
import com.hanchenj.tradingapp.option.domain.Option;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TradierClient implements OptionInfoClient {
    private RestTemplate restTemplate;

    public TradierClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Option> getOptionChain(String ticker) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("symbol", ticker);
        LocalDate today = LocalDate.now(ZoneId.of("America/New_York"));
        urlVariables.put("expiration", DateTimeFormatter.ISO_LOCAL_DATE.format(today));

        ResponseEntity<TradierOptionChainResponse> responseEntity = this.restTemplate.exchange(
                "https://sandbox.tradier.com/v1/markets/options/chains",
                HttpMethod.GET,
                null,
                TradierOptionChainResponse.class,
                urlVariables);
        return responseEntity.getBody();
    }
}
