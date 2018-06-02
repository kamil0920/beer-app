package org.moveApp.convert;

import org.moveApp.domain.DataBeer;
import org.moveApp.dto.DataBeerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverBeerToBeerDto implements Converter<DataBeerDto, DataBeer> {

    @Override
    public DataBeer convert(DataBeerDto dataBeerDto) {

        final DataBeer beerData = new DataBeer();

        beerData.setPunkapiId(dataBeerDto.getId());
        beerData.setName(dataBeerDto.getName());
        beerData.setDescription(dataBeerDto.getDescription());
        beerData.setFirstBrewed(dataBeerDto.getFirstBrewed());
        beerData.setIbu(dataBeerDto.getIbu());
        beerData.setImageUrl(dataBeerDto.getImageUrl());
        beerData.setTagline(dataBeerDto.getTagline());
        beerData.setFoodPairing(dataBeerDto.getFoodPairing());

        return beerData;
    }
}
