package com.rocketman.storeroom.repository;

import org.springframework.data.repository.CrudRepository;
import com.rocketman.storeroom.entity.DbObject.UserObject;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserObject, Long> {

    Optional<UserObject> findByName();
}
