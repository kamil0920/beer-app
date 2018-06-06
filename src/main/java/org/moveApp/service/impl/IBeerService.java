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
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    @Override
    public List<DataBeer> getAllBeers() {

        List<DataBeerDto> listBeerDto = dataLoad.getBeers();

        for (DataBeerDto beer : listBeerDto) {
            DataBeer beerData = convertBeerDtoToBeer.convert(beer);

            List<DataBeer> dataBeerOptional = beerRepository.findAll();

            if (!dataBeerOptional.contains(beerData)) {
                beerRepository.save(beerData);
            }

        }
        return beerRepository.findAll();
    }


    @Override
    public List<DataBeer> findBeerByPhrase(String phrase) {

        Optional<List<DataBeer>> list = beerRepository.findByFoodPairingPhrase(phrase);

        if (!list.isPresent()) {
            throw new ResourceNotFound();
        } else {
            return list.get();
        }
    }

    @Override
    public DataBeerDto createBeer(DataBeerDto data) {

        DataBeer dataBeer = convertBeerDtoToBeer.convert(data);
        DataBeer savedDataBeer = beerRepository.save(dataBeer);
        DataBeerDto returnedDto = converBeerToBeerDto.convert(savedDataBeer);

        log.info("Beer with id: " + dataBeer.getPunkapiId() + " was created.");

        return returnedDto;
    }
}
