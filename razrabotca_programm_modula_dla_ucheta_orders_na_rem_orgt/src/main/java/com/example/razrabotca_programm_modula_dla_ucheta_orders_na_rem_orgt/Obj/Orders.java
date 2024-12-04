package com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.Obj;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // создание таблицы
@Data   // гетеры + сетеры(инкапсуляцыя)
@Table(name = "zai") // имя таблицы
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int authorId; // для отслеживания того кому принадлежит заявка

    LocalDate dateAdd;
    String poroblem;
    String model;
    String dis;
    String worcer;
    String status;
    
}
