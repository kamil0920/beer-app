package org.moveApp.controller;


import org.moveApp.domain.DataBeer;
import org.moveApp.dto.DataBeerDto;
import org.moveApp.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerController {

    @Autowired
    private BeerService beerService;


    @GetMapping
    public ResponseEntity<List<DataBeer>> getBeers(){

        List<DataBeer> beerData = beerService.getAllBeers();

        return new ResponseEntity<List<DataBeer>>(beerData, HttpStatus.OK);
    }

    @GetMapping("/foodpairings/search/{phrase}")
    public ResponseEntity<List<DataBeer>> getBeerByPhrease(@PathVariable String phrase){

        List<DataBeer> beerData = beerService.findBeerByPhrase(phrase);

        return new ResponseEntity<List<DataBeer>>(beerData, HttpStatus.OK);
    }

    @PostMapping("/beers")
    @ResponseStatus(HttpStatus.CREATED)
    public DataBeerDto addBeer(@RequestBody DataBeerDto beerDto){
        return beerService.createBeer(beerDto);

    }
}
