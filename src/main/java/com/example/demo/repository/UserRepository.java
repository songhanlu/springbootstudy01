package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 2019/4/19.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
