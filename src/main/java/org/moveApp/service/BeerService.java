package org.moveApp.service;

import org.moveApp.domain.DataBeer;
import org.moveApp.dto.DataBeerDto;

import java.util.List;

public interface BeerService {

    List<DataBeer> getAllBeers();

    List<DataBeer> findBeerByPhrase(String phrase);

    DataBeerDto createBeer(DataBeerDto data);
}
