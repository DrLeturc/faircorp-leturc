package com.emse.spring.faircorp.hello;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



//INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature) VALUES(-10, 'Room1', 1, 22.3, 20.0);
//INSERT INTO ROOM(id, name, floor) VALUES(-9, 'Room2', 1);
//
//INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-10, 'ON', 'Heater1', 2000, -10);
//INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-9, 'ON', 'Heater2', null, -10);
//
//INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-10, 'CLOSED', 'Window 1', -10);
//INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-9, 'CLOSED', 'Window 2', -10);
//INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-8, 'OPEN', 'Window 1', -9);
//INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-7, 'CLOSED', 'Window 2', -9);

public class DataBaseConnectionExample {

	Connection connection;
	
	String database_url = "jdbc:h2:mem:bigcorp;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"; // (2)
	String username = "christopher";
	String password = "test";
	
//	Logger logger = System.getLogger("christopher");
	
	// Selection sensors
	// select c from Sensor c

	// Selection sites linked to a sensor
	// select c.site from Sensor c
	
	// implicit join
	// select c from Sensor c where c.site.id = :siteId
	
	// explicit join
	// select c from Sensor c join c.site s where s.id = :siteId
	// select c from Sensor c left join c.site s where s.id = :siteId
	public void insertRequestExample(Site site) throws DatabaseException{
	    try(Connection conn = DriverManager.getConnection(database_url, username, password)){//dataSource.getConnection()
	        String sql = "insert into SITE (id, name) values (?, ?)";
	        try(PreparedStatement stmt = conn.prepareStatement(sql)){
	          stmt.setString(1, site.getId().toString());
	          stmt.setString(2, site.getName());
	          stmt.executeUpdate();
	        }
	    }
	    catch(SQLException e) {
	        throw new DatabaseException("Impossible to insert site " +
	            site.getName(), e); // DatabaseException ??
	    }
	}
	
	
	public List<Site> findAll() throws DatabaseException {
	    List<Site> sites = new ArrayList<>();
	    try(Connection conn = DriverManager.getConnection(database_url, username, password)){ //dataSource.getConnection()
	        String sql = "select id, name from SITE";
	        try(PreparedStatement stmt = conn.prepareStatement(sql)){
	            try (ResultSet resultSet = stmt.executeQuery()) {
	                while(resultSet.next()) {
	                    Site s = new Site(resultSet.getString("name"));
	                    s.setId(Long.getLong(resultSet.getString("id")));
	                    sites.add(s);
	                }
	            }
	        }
	    }
	    catch(SQLException e) {
	        throw new DatabaseException("Impossible to read sites", e);
	    }
	    return sites;
	}
	
	private void testConnectionVeryLow() {
		try {
			  Class.forName("org.h2.Drive"); // (1)
			}
			catch (ClassNotFoundException e) {
//			  logger.error("Unable to load JDBC Driver", e);
			}
			try {
			  
			  
			  connection = DriverManager.getConnection(database_url, username, password); // (3)
			}
			catch (SQLException e) {
				System.err.println("Unable to connect to the database"+ e);//logger.error("Unable to connect to the database", e);
			}
	}
	
	
	public void insertSite(Site site) throws DatabaseException { 
        try(Connection conn = DriverManager.getConnection(database_url, username, password)){//dataSource.getConnection()
            conn.setAutoCommit(false); // 1.
            String sql = "insert into SITE (id, name) values (?, ?)";

            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, site.getId().toString());
                stmt.setString(2, "toto");
                stmt.executeUpdate();
                conn.commit(); // 2.
            }
            catch(SQLException e) {
                conn.rollback(); // 3.
                throw new DatabaseException("Impossible ins&#xE9;rer site " + site.getName(), e);
            }
        }
        catch(SQLException e) {
            throw new DatabaseException("Impossible ins&#xE9;rer site " + site.getName(), e);
        }
    }
	
}
