package org.moveApp.convert;

import org.moveApp.domain.DataBeer;
import org.moveApp.dto.DataBeerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverBeerToBeerDto implements Converter<DataBeer, DataBeerDto> {

    @Override
    public DataBeerDto convert(DataBeer dataBeer) {

        DataBeerDto dataBeerDto = new DataBeerDto();

        dataBeerDto.setId(dataBeer.getPunkapiId());
        dataBeerDto.setName(dataBeer.getName());
        dataBeerDto.setDescription(dataBeer.getDescription());
        dataBeerDto.setFirstBrewed(dataBeer.getFirstBrewed());
        dataBeerDto.setIbu(dataBeer.getIbu());
        dataBeerDto.setImageUrl(dataBeer.getImageUrl());
        dataBeerDto.setTagline(dataBeer.getTagline());
        dataBeerDto.setFoodPairing(dataBeer.getFoodPairing());

        return dataBeerDto;
    }
}
