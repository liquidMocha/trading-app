package com.hanchenj.tradingapp.option.client.Tradier;

import com.hanchenj.tradingapp.option.client.OptionInfoClient;
import com.hanchenj.tradingapp.option.domain.Option;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

@Component
public class TradierClient implements OptionInfoClient {
    private RestTemplate restTemplate;

    public TradierClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Option> getOptionChain(String ticker, String authToken) {
        LocalDate today = LocalDate.now(ZoneId.of("America/New_York"));

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://sandbox.tradier.com/v1/markets/options/chains")
                .queryParam("symbol", ticker)
//                .queryParam("expiration", DateTimeFormatter.ISO_LOCAL_DATE.format(today));
                .queryParam("expiration", "2019-03-01");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", authToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TradierOptionChainResponse> responseEntity = this.restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                TradierOptionChainResponse.class);
        TradierOptionChainResponse response = responseEntity.getBody();

        return response.transformToOptions();
    }
}
