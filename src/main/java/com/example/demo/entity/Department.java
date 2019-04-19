package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ASUS on 2019/4/18.
 */
@Data
@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


}
