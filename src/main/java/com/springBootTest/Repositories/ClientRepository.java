package com.springBootTest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootTest.Beans.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{}
