package com.alternance.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alternance.test.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	boolean existsByUsername (String titre);
}
