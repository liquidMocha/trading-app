package com.hanchenj.tradingapp;

import com.hanchenj.tradingapp.option.client.OptionInfoClient;
import com.hanchenj.tradingapp.option.domain.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TradingAppApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OptionInfoClient optionInfoClient;

    @Test
    public void listOptionChainForSingleTicker() throws Exception {
        List<Option> optionChain = new ArrayList<>();
        optionChain.add(Option.builder().ask(20.1).bid(22.2).build());

        when(optionInfoClient.getOptionChain(any(), any())).thenReturn(optionChain);

        URI uri = new URI("/option/APPL");

        mockMvc.perform(
                get(uri).header("Authorization", "abc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].ask").value(20.1))
                .andExpect(jsonPath("[0].bid").value(22.2));
    }

}
