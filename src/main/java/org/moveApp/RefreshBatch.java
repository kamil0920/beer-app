package org.moveApp;

import lombok.extern.slf4j.Slf4j;
import org.moveApp.domain.DataBeer;
import org.moveApp.repository.BeerRepository;
import org.moveApp.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class RefreshBatch {

    @Autowired
    private BeerService beerService;

    @Autowired
    private BeerRepository beerRepository;

    @Scheduled(
            cron = "0 0 * * * *")
    public void cronJob(){

        List<DataBeer> list = beerService.getAllBeers();

        beerRepository.saveAll(list);

        log.info("CRON JOB");
    }
}
