package com.sidant.mimir.Model;

import com.sidant.mimir.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(Integer userId);

    Optional<User> findById(long id);


}
