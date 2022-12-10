package com.sidant.mimir.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<BotUsers, Long> {

    Optional<BotUsers> findByUsername(String username);

    Optional<BotUsers> findByUserId(long userId);

    Optional<BotUsers> findById(long id);


}
