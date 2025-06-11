package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jt;

    // ❌ Table creation is commented (for production/stable DB)
    /*
    private void createTableIfNotExists() {
        String query = "CREATE TABLE IF NOT EXISTS USER(" +
                       "ID INT PRIMARY KEY, " +
                       "NAME VARCHAR(50), " +
                       "AGE INT, " +
                       "CITY VARCHAR(50))";
        jt.execute(query);
    }
    */

    // ❌ Insert operation is commented (to avoid duplicate error)
    /*
    private int insertData(User user) {
        String query = "INSERT INTO USER(ID, NAME, AGE, CITY) VALUES (?, ?, ?, ?)";
        return jt.update(query, user.getId(), user.getName(), user.getAge(), user.getCity());
    }
    */

    // ✅ Delete operation by ID
    private Integer deleteUserById(Integer id) {
        String query = "DELETE FROM USER WHERE ID = ?";
        return jt.update(query, id);
    }
    
    //update query
    private Integer updateUser(Integer id, String city) {
    	String query = "update user set city = ? where id = ?";
    	int count = jt.update(query,city,id);
    	return count;
    }
    // select query
    	private List<User> selectUsers() {
    	String query = "select * from user";
    	return jt.query(
    			query,
    			(rs, rowNum) -> new User(
    					rs.getInt("id"),
    					rs.getString("name"),
    					rs.getInt("age"),
    					rs.getString("city")));
    					
    					
    					
    			
    	}
    	
    
    
    @Override
    public void run(String... args) throws Exception {
        // ❌ No table creation or insertion
        // createTableIfNotExists();
        // int rowsInserted = insertData(new User(3, "Riya", 28, "Latur"));
        // System.out.println("Rows inserted: " + rowsInserted);
        // ✅ Perform delete operation
        //System.out.println("Deleted rows: " + deleteUserById(3));
    	//System.out.println("update data : "+updateUser(1,"Nagpur"));
    	List<User> list = selectUsers();
    	list.forEach(System.out::println);
    	
    }
}
