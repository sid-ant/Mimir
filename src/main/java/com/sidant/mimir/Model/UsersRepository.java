package com.sidant.mimir.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    Optional<Users> findByUserId(long userId);

    Optional<Users> findById(long id);


}
