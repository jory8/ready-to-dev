package com.joolbite.incognito.repo;

import com.joolbite.incognito.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(" select u from User u" +
            " where u.username = :username")
    User findUserWithName(@Param("username")String username);

    @Query(" select u from User u" +
            " where u.userId = :id")
    User findUserById(@Param("id")Long id);

    @Query(" select u from User u" +
            " where u.mail = :mail" +
            " and u.password = :password")
    User findUserByMailAndPassword(@Param("mail")String mail, @Param("password")String password );
}
