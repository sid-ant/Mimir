package com.sidant.mimir.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelemetryService {

    Logger logger = LoggerFactory.getLogger(TelemetryService.class);

    @Autowired
    TelemetryRepository telemetryRepository;

    public void incrementText(Long userId) {

        Optional<Telemetry> telemetry = telemetryRepository.findByUserId(userId);

        if (telemetry.isPresent()) {
            Telemetry present = telemetry.get();
            present.setTextCount(present.getTextCount()+1);
            telemetryRepository.save(present);
        } else {
            telemetryRepository.save(new Telemetry(userId,1L,0L));
        }
    }

    public  void incrementPhoto(Long userId) {

        Optional<Telemetry> telemetry = telemetryRepository.findByUserId(userId);

        if (telemetry.isPresent()) {
            Telemetry present = telemetry.get();
            present.setTextCount(present.getImageCount() + 1);
            telemetryRepository.save(present);
        } else {
            telemetryRepository.save(new Telemetry(userId, 0L, 1L));

        }
    }

}
