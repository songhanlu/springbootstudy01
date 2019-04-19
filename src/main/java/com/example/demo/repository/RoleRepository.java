package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ASUS on 2019/4/19.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByName(String name);
}
