package edu.iit.sat.itmd4515.wlin35;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wlin35
 */
public class ArtistJDBCTest {
    
    private Connection conn;

    // utility or helper methods
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/chinook";
        String username = "itmd4515";
        String password = "itmd4515";

        return DriverManager.getConnection(url, username, password);
    }
    
    private void createAArtist(Artist a) throws SQLException{
        String Insert_sql = "INSERT INTO  artist "
                +"(ArtistId,Name) "
                +" values(?,?)";
        
        PreparedStatement stmt = conn.prepareStatement(Insert_sql);
        
        stmt.setInt(1,a.getArtistId());
        stmt.setString(2,a.getName());
       
        stmt.executeUpdate();
    }
    
    private void updateAArtist(Artist a) throws SQLException{
        String Update_sql = "UPDATE artist set "
                +"name = ?"
                +"WHERE artistId = ?";
        
        PreparedStatement ps = conn.prepareStatement(Update_sql);
        
        ps.setInt(2, a.getArtistId());
        ps.setString(1, a.getName());
        
        ps.executeUpdate();
    }
    
    private void deleteAArtist(Integer artistId) throws SQLException{
        String Delete_sql = "DELETE FROM Artist WHERE ArtistId = ?";
        PreparedStatement  ps = conn.prepareStatement(Delete_sql);
        ps.setInt(1,artistId);
        ps.executeUpdate();
    }
    
    private Artist findAArtist(Integer artistId) throws SQLException{
        String Select_sql = "SELECT * FROM Artist WHERE ArtistId = ?";
       
        Artist a = null;
        
        PreparedStatement ps = conn.prepareStatement(Select_sql);
        
        ps.setInt(1, artistId);
        
        ResultSet rs = ps.executeQuery();
        
       if(rs.next()){
           a = new Artist();
           a.setArtistId(rs.getInt("artistId"));
           a.setName(rs.getString("name"));
       }
       
       return a;
    }
    
    @BeforeAll
    public static void beforeAll(){
    }
    
    @BeforeEach
    public void beforeEach() throws SQLException{
        conn = getConnection();
        
        Artist a = new Artist(999,"Michael Jackson");
        createAArtist(a);
    }
    
    @Test
    public void createArtistTest() throws SQLException {
        // 1) Create a new customer
        Artist a = new Artist(1000,"Westlife");
        createAArtist(a);

        // 2) Find that customer in the DB to assert it was created successfully
        Artist foundArtist = findAArtist(1000);
        assertNotNull(foundArtist);
        assertEquals(1000, foundArtist.getArtistId());
        System.out.println("Create Test passed!");
        // 3) Cleanup
        deleteAArtist(1000);
    }

    @Test
    public void readArtistTest() throws SQLException {
        // 1) Find a known customer in the DB
        Artist a = findAArtist(999);
        System.out.println(a.toString());
        // 2) Assert that we were able to read it successfully
        assertNotNull(a);
        assertEquals(999, a.getArtistId());
        System.out.println("Read Test passed! \n the No.999 artist name is:{}"+a.getName());
        
    }

    @Test
    public void updateArtistTest() throws SQLException {
        // 1) Update a known customer in the DB
        Artist a = findAArtist(999);
        a.setName("**UPDATED**");
        updateAArtist(a);

        // 2) Find that same customer in the DB to assert the updates were
        //    applied to the database successfully
        Artist foundArtist = findAArtist(999);
        System.out.println(foundArtist.toString());
        assertEquals("**UPDATED**", foundArtist.getName());
        System.out.println("Update Test passed!");
    }

    @Test
    public void deleteArtistTest() throws SQLException {
        // 1) Create a new customer (careful with beforeEach test record)
        // 2) Delete it
        // 3) Assert the deletion was successful.  Hint - would it be null?  
        //    depends on how you write your code, but that's one way to check
        //    Essentially, you are asserting that you could not find the record
        Artist a = new Artist(1000,"Westlife");
        createAArtist(a);
        System.out.println("No.1000 artist created!");
        // 2) Find that customer in the DB to assert it was created successfully
        Artist foundArtist = findAArtist(1000);
        assertNotNull(foundArtist);
        assertEquals(1000, foundArtist.getArtistId());
        System.out.println("Delete Test....");
        // 3) Cleanup
        deleteAArtist(1000);
        Artist deleteArtist = findAArtist(1000);
        assertNull(deleteArtist);
        System.out.println("Delete successfully!");
    }
    
     @AfterEach
    public void afterEach() throws SQLException {
        // delete the test customer from beforeEach
        deleteAArtist(999);
        // close our connection
        conn.close();
    }

    @AfterAll
    public static void afterAll() {
    }
}
