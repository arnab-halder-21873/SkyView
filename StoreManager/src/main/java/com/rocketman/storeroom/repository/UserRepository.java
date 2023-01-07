package com.rocketman.storeroom.repository;

import org.springframework.data.repository.CrudRepository;
import com.rocketman.storeroom.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByName();
}
