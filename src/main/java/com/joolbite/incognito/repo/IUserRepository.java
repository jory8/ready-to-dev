package com.joolbite.incognito.repo;

import com.joolbite.incognito.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(" select u from User u " +
            " where u.username = ?1")
    Optional<User> findUserWithName(String username);

}
