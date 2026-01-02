package com.spring.restapi.sbrestapi;

import org.springframework.data.repository.CrudRepository;

public interface AlienRepository extends CrudRepository<Alien, Integer> {
    // CrudRepository is a Spring Data JPA interface that provides basic CRUD
    // operations without writing SQL or JPQL.

    // CrudRepository<Alien, Integer>
    // Generic Meaning
    // Alien Entity class
    // Integer Type of primary key (@Id)

    /*
     * Why CrudRepository is used
     * > Without CrudRepository -
     * 
     * You would need to write:
     * JDBC code
     * SQL queries
     * PreparedStatement
     * ResultSet mapping
     * Transaction handling
     * 
     * > With CrudRepository -
     * 
     * Spring:
     * Generates SQL automatically
     * Manages transactions
     * Handles connections
     * Maps rows → objects
     * 
     * >>>> Less code, fewer bugs, faster development
     */

    // Core CRUD Methods Provided by CrudRepository
    // These methods are already implemented by Spring at runtime.
}