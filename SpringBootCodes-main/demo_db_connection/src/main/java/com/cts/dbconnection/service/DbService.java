package com.cts.dbconnection.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cts.dbconnection.dao.DbConnection;

@Service 
public class DbService {
	
	@Autowired
//	@Qualifier("oracle") // Important rule: @Qualifier overrides @Primary
	DbConnection dbs;
	
	public String getDriverName() {
		return dbs.getDriver();
	}
	
	public String getDatabaseName() {
		return dbs.getDatabase();
	}
}