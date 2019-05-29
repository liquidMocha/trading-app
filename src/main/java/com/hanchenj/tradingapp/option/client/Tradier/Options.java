
package com.hanchenj.tradingapp.option.client.Tradier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Slf4j
class Options {

    @JsonProperty("option")
    private List<Option> options = new ArrayList<>();

    List<com.hanchenj.tradingapp.option.domain.Option> transformToDomainOptions() {
        return options.stream().map(theOption -> {
            try {
                return new com.hanchenj.tradingapp.option.domain.Option(
                        theOption.getAsk(),
                        Double.valueOf(theOption.getBid()),
                        getExpirationDate(theOption),
                        theOption.getExpirationType(),
                        theOption.getRootSymbol(),
                        theOption.getStrike(),
                        theOption.getSymbol(),
                        theOption.getTradeDate(),
                        theOption.getUnderlying());
            } catch (ParseException | DateTimeParseException e) {
                log.error("Cannot parse expiration date.");
            }

            return null;
        }).collect(Collectors.toList());
    }

    private LocalDate getExpirationDate(Option option) throws ParseException {
        String[] descriptionTokens = option.getDescription().split("\\s+");
        String[] dateParts = Arrays.copyOfRange(descriptionTokens, 1, 4);

        return LocalDate.parse(dateParts[2] + "-" + getMonthNumber(dateParts[0]) + "-" + dateParts[1]);
    }

    private String getMonthNumber(String datePart) throws ParseException {
        Date date = new SimpleDateFormat("MMMM").parse(datePart);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int monthNumber = cal.get(Calendar.MONTH);

        String monthNumberAsString = Integer.toString(monthNumber+1);

        if (monthNumber < 10) {
            monthNumberAsString = "0" + monthNumberAsString;
        }
        return monthNumberAsString;
    }

    void addToOptions(Option option) {
        this.options.add(option);
    }
}
