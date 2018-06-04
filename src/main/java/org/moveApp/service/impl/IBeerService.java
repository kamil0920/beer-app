package org.moveApp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.moveApp.convert.ConverBeerToBeerDto;
import org.moveApp.convert.ConvertBeerDtoToBeer;
import org.moveApp.domain.DataBeer;
import org.moveApp.dto.DataBeerDto;
import org.moveApp.exception.ResourceNotFound;
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
    private final ConverBeerToBeerDto converBeerToBeerDto;
    private final ConvertBeerDtoToBeer convertBeerDtoToBeer;

    private final BeerRepository beerRepository;

    @Autowired
    public IBeerService(DataLoad dataLoad,
                        ConverBeerToBeerDto converBeerToBeerDto,
                        ConvertBeerDtoToBeer convertBeerDtoToBeer,
                        BeerRepository beerRepository) {

        this.dataLoad = dataLoad;
        this.converBeerToBeerDto = converBeerToBeerDto;
        this.convertBeerDtoToBeer = convertBeerDtoToBeer;
        this.beerRepository = beerRepository;

    }


    @Override
    public List<DataBeer> getAllBeers() {

        List<DataBeerDto> listBeerDto = dataLoad.getBeers();
        List<DataBeer> listBeers = new LinkedList<>();

        for (DataBeerDto beer : listBeerDto) {
            DataBeer beerData = convertBeerDtoToBeer.convert(beer);
            listBeers.add(beerData);
        }

        beerRepository.saveAll(listBeers);

        return listBeers;
    }

    @Override
    public List<DataBeer> findBeerByPhrase(String phrase) {

        List<DataBeer> dataBeers = (List<DataBeer>) beerRepository.findAll();

        if (dataBeers.isEmpty()) {
            throw new ResourceNotFound();
        }

        List<DataBeer> beersWithPhrase = new LinkedList<>();

        for (DataBeer dataB : dataBeers) {
            List<String> s = dataB.getFoodPairing();

            for (String str : s) {
                if (str.contains(phrase)) {
                    beersWithPhrase.add(dataB);
                }
            }
        }

        if (beersWithPhrase.isEmpty()) {
            throw new ResourceNotFound();
        }

        return beersWithPhrase;
    }

    @Override
    public DataBeerDto createBeer(DataBeerDto data) {
//        ??
        Optional<DataBeer> beerOptional = beerRepository.findByPunkapiId(data.getId());

        if (!beerOptional.isPresent()) {
            DataBeer dataBeer = convertBeerDtoToBeer.convert(data);

            DataBeer savedDataBeer = beerRepository.save(dataBeer);

            DataBeerDto returnedDto = converBeerToBeerDto.convert(savedDataBeer);

            log.info("Beer with id: " + dataBeer.getPunkapiId() + " was created.");

            return returnedDto;

        } else {
            throw new RuntimeException("Beer exist");
        }
    }
}
