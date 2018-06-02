package org.moveApp.repository;


import org.moveApp.domain.DataBeer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends CrudRepository<DataBeer, Long> {

}
