package com.sidant.mimir.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TelemetryRepository extends CrudRepository<Telemetry,Long> {

    Optional<Telemetry> findByUserId(Long userId);


}
