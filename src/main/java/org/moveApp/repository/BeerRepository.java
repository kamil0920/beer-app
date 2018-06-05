package org.moveApp.repository;


import org.moveApp.domain.DataBeer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeerRepository extends CrudRepository<DataBeer, Long> {

    Optional<DataBeer> findByPunkapiId(Integer id);


    @Query("select b from DataBeer b join b.foodPairing fp where lower(fp) like lower(concat('%', :phrase, '%'))")
    Optional<List<DataBeer>> findByFoodPairingPhrase(@Param("phrase") String phrase);

}
