package com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.Obj;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String login;
    String pass;
    String roll;
    String name;
    String lastName;
    String fatherName;
    String phoneNum;
}
