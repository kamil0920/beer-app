package org.moveApp;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

    @Test
    public void getBeers() {

        String api_url = "https://api.punkapi.com/v2/beers";

        RestTemplate restTemplate = new RestTemplate();

        JsonNode jsonNode = restTemplate.getForObject(api_url, JsonNode.class);

        System.out.println("Response:");
        System.out.println(jsonNode.toString());
    }

}
