package org.moveApp.convert;

import org.moveApp.domain.DataBeer;
import org.moveApp.dto.DataBeerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertBeerDtoToBeer implements Converter <DataBeerDto, DataBeer> {

    @Override
    public DataBeer convert(DataBeerDto dataBeerDto) {

        DataBeer dataBeer = new DataBeer();

//        dataBeer.set(dataBeerDto.getId());
        dataBeer.setName(dataBeerDto.getName());
        dataBeer.setDescription(dataBeerDto.getDescription());
        dataBeer.setFirstBrewed(dataBeerDto.getFirstBrewed());
        dataBeer.setIbu(dataBeerDto.getIbu());
        dataBeer.setImageUrl(dataBeerDto.getImageUrl());
        dataBeer.setTagline(dataBeerDto.getTagline());
        dataBeer.setFoodPairing(dataBeerDto.getFoodPairing());

        return dataBeer;

    }


}
