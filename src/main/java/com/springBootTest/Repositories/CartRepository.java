package com.springBootTest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootTest.Beans.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
