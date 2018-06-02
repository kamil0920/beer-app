package org.moveApp.service;

import org.moveApp.domain.DataBeer;

import java.util.List;

public interface BeerService {

    List<DataBeer> getAllBeers();

    List<DataBeer> findBeerByPhrase(String phrase);

    DataBeer creatBeer(DataBeer data);
}
