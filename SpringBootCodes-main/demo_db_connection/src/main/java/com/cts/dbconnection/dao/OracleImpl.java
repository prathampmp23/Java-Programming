package com.cts.dbconnection.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // used to resolve ambiguity when multiple beans of the same type exist
@Component 
//@Component("oracle") //if we want to use @Qualifier("oracle") in service instead of @Primary in implemented class
public class OracleImpl implements DbConnection {

	@Override
	public String getDriver() {
		return "Type2 driver is loaded";
	}

	@Override
	public String getDatabase() {
		return "Oracle database is used";
	}
}
 