package com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.repos;


import org.springframework.data.repository.CrudRepository;

import com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.Obj.Orders;


public interface OrderRepos extends CrudRepository<Orders,Integer> {

    Orders findById(int id);
    
}
