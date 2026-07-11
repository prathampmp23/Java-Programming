package com.cts.dbconnection.dao;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
public class DbConnectionImpl implements DbConnection {
 
	@Override
	public String getDriver() {
		return "Type1 driver is laoded";
	}
 
	@Override
	public String getDatabase() {
		return "MySql Database is used";
	}
}
