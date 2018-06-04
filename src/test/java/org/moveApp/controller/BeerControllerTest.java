package org.moveApp.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.moveApp.domain.DataBeer;
import org.moveApp.dto.DataBeerDto;
import org.moveApp.service.BeerService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
//@WebAppConfiguration
public class BeerControllerTest extends AbstractRestController {

    @Mock
    BeerService beerService;

    @InjectMocks
    BeerController beerController;


    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(beerController).build();
    }

    @Test
    public void getBeers() throws Exception {

        mockMvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBeerByPhrase() throws Exception {
        List<DataBeer> list = new LinkedList<>();

        DataBeer dataBeer = new DataBeer();
        dataBeer.setPunkapiId(1);
        dataBeer.setName("Perla");
        dataBeer.setFoodPairing(Arrays.asList("Spicy chicken tikka masala",
                                              "Grilled chicken quesadilla",
                                              "Caramel toffee cake"));

        list.add(dataBeer);

        when(beerService.findBeerByPhrase(anyString())).thenReturn(list);

        mockMvc.perform(get("/foodpairings/search/tikka")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(dataBeer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        verify(beerService, times(1)).findBeerByPhrase(anyString());
    }

    @Test
    public void addBeer() throws Exception {

        DataBeerDto beerDto = new DataBeerDto();
        beerDto.setId(1);
        beerDto.setName("Perla");
        beerDto.setFirstBrewed("asd");

        DataBeerDto beer = new DataBeerDto();
        beer.setName(beerDto.getName());
        beer.setFirstBrewed(beerDto.getFirstBrewed());
        beer.setId(1);

        when(beerService.createBeer(beerDto)).thenReturn(beer);

        mockMvc.perform(post("/beers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(beer)))
                .andExpect(status()
                        .isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.name", equalTo("Perla")));

        verify(beerService, times(1)).createBeer(beer);

    }
}


















