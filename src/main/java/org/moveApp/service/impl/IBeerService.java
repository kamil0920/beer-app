package org.moveApp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.moveApp.convert.ConverBeerToBeerDto;
import org.moveApp.domain.DataBeer;
import org.moveApp.dto.DataBeerDto;
import org.moveApp.exception.NotFoundBeerException;
import org.moveApp.repository.BeerRepository;
import org.moveApp.service.BeerService;
import org.moveApp.service.DataLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class IBeerService implements BeerService {

    private final DataLoad dataLoad;
    private final ConverBeerToBeerDto convertDataDtoToData;

    private final BeerRepository beerRepository;

    @Autowired
    public IBeerService(DataLoad dataLoad, ConverBeerToBeerDto convertDataDtoToData, BeerRepository beerRepository) {
        this.dataLoad = dataLoad;
        this.convertDataDtoToData = convertDataDtoToData;
        this.beerRepository = beerRepository;
    }


    @Override
    public List<DataBeer> getAllBeers() {

        List<DataBeerDto> listBeerDto = dataLoad.getBeers();
        List<DataBeer> listBeers = new LinkedList<>();

        for (DataBeerDto beer : listBeerDto) {
            DataBeer beerData = convertDataDtoToData.convert(beer);
            listBeers.add(beerData);
            beerRepository.save(beerData);
        }

        return listBeers;
    }

    @Override
    public List<DataBeer> findBeerByPhrase(String phrase) {
        Optional<Iterable<DataBeer>> optionalDataBeers = Optional.of(beerRepository.findAll());

        if (optionalDataBeers.isPresent()) {
            List<DataBeer> dataBeers = (List<DataBeer>) optionalDataBeers.get();

            List<DataBeer> beersWithPhrase = new LinkedList<>();

            for (DataBeer dataB : dataBeers) {
                List<String> s = dataB.getFoodPairing();

                for (String str : s) {
                    if (str.contains(phrase)) {
                        beersWithPhrase.add(dataB);
                    }
                }
            }
            return beersWithPhrase;
        } else {
            throw new NotFoundBeerException();
        }
    }

    @Override
    public DataBeer createBeer(DataBeerDto data) {
        Optional<DataBeer> beerOptional = beerRepository.findByPunkapiId(data.getId());

        if (!beerOptional.isPresent()){
            DataBeer dataBeer = convertDataDtoToData.convert(data);

            beerRepository.save(dataBeer);

            log.info("Beer with id: " + dataBeer.getPunkapiId() + " was created.");

            return dataBeer;

        } else {
            throw new RuntimeException("Beer exist");
        }
    }
}
