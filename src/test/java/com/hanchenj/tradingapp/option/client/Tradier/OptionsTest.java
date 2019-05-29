package com.hanchenj.tradingapp.option.client.Tradier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.fail;

class OptionsTest {

    @Test
    void getExpirationDateFromDescription() {
        Options options = new Options();
        options.addToOptions(
                Option.builder()
                        .expirationDate(null)
                        .description("LYFT May 31 2019 $35.00 Put")
                        .build());

        List<com.hanchenj.tradingapp.option.domain.Option> actual = options.transformToDomainOptions();

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getExpirationDate()).isEqualTo(LocalDate.of(2019, 5, 31));
    }

    @Test
    void shouldCatchParseExceptionIfDateIsNotParsable() {
        Options options = new Options();
        options.addToOptions(
                Option.builder()
                        .description("LYFT April 31 2019 $35.00 Put")
                        .build()
        );
        try {
            List<com.hanchenj.tradingapp.option.domain.Option> actual = options.transformToDomainOptions();
            assertThat(actual.get(0)).isNull();
        } catch (Exception e) {
            fail("Should have caught exceptions");
        }
    }
}