package org.moveApp;

import lombok.extern.slf4j.Slf4j;
import org.moveApp.domain.DataBeer;
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

    public RefreshBatch(BeerService beerService) {
        this.beerService = beerService;
    }

    @Scheduled(
            cron = "0,15 * * * * *"
//                    "0 0 * * * *"
    )
    public void cronJob(){

        List<DataBeer> list = beerService.getAllBeers();

        log.info("CRON JOB");
    }
}
