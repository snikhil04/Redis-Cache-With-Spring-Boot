package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
}
