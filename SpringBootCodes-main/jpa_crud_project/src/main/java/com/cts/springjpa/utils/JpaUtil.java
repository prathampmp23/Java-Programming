package com.cts.springjpa.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// JpaUtil is a utility class that:
// Creates one shared EntityManagerFactory
// Provides EntityManager instances to DAO classes
public class JpaUtil {

	// EntityManagerFactory is a heavy weight object
//	Created only once for the entire application
//	"student" is the persistence unit name, defined in resources> META-INF> persistence.xml
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");

	// Creates a new EntityManager
//	EntityManager is lightweight and not thread-safe
//	Should be created per request / per DAO operation
	public static EntityManager getEntityManager() { // Talks to the database
		return emf.createEntityManager();
	}
}
