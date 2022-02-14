/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.wlin35;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author 92809
 */
public class ArtistValidationTest {
    
    
    private static Validator validator;
    
    @BeforeAll
    public static void beforeAll() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @BeforeEach
    public void beforeEach() {
    }
    
    @Test
    public void tesValidatetInvalidTitleValidationShouldFail(){
        Artist a = new Artist(null,"Adele");
        Set<ConstraintViolation<Artist>> violations = validator.validate(a);
        for(ConstraintViolation<Artist> violation : violations){
            System.out.println(violation.toString());
        }
        assertEquals(1, violations.size());
        assertEquals("must be fill artist id", violations.iterator().next().getMessage());
    }
    @Test
    public void tesValidatetInvalidTitleValidationShouldPass(){
        Artist a = new Artist(2223,"Adele");
        Set<ConstraintViolation<Artist>> violations = validator.validate(a);
        for(ConstraintViolation<Artist> violation : violations){
            System.out.println(violation.toString());
        }
        assertEquals(0, violations.size());
        System.out.println("Test passed!");
       // assertEquals("must be fill artist id", violations.iterator().next().getMessage());
    }
    
    @AfterEach
    public void afterEach() {
    }

    @AfterAll
    public static void afterAll() {
    }

}
