package com.sidant.mimir.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRepository extends CrudRepository<Usage, Long> {

}
