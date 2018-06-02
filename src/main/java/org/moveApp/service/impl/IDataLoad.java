package org.moveApp.service.impl;


import org.moveApp.dto.DataBeerDto;
import org.moveApp.service.DataLoad;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IDataLoad implements DataLoad {

    private String url = "https://api.punkapi.com/v2/beers";

    @Override
    public List<DataBeerDto> getBeers() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<DataBeerDto>> rateResponse =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<DataBeerDto>>() {
                        });

        List<DataBeerDto> rates = rateResponse.getBody();

        return rates;

    }
}
