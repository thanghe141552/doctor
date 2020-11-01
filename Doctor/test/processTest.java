/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class processTest {
    
    public processTest() {
    }
    ArrayList<Doctor> list = new ArrayList<>();
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInt method, of class process.
     */
    @Test
    public void testcheckName() {
        System.out.println("checkName");
        valid instance = new valid();       
        boolean result = instance.checkName("thang");     
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testNameInBound() {
        System.out.println("checkBoundaryName");
        valid instance = new valid();       
        boolean result = instance.checkName("ababababababababababababababababababababababababa");     
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testNumberOfCharacterInName() {
        System.out.println("charOutOfBoundName");
        valid instance = new valid();       
        boolean result = instance.checkName("abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd");     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testEmptyName() {
        System.out.println("EmptyName");
        valid instance = new valid();       
        boolean result = instance.checkName("");     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testValidDate() {
        System.out.println("validDate");
        valid instance = new valid();
        boolean result = instance.checkDateOfBirthFormat("22/04/2000");
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testInvalidDate() {
        System.out.println("invalidDate");
        valid instance = new valid();
        boolean bool = false;
        boolean result = instance.checkDateOfBirthFormat("22-22-2000");
        assertEquals(bool,result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testInvalidDate_2() {
        System.out.println("invalidDate2");
        valid instance = new valid();
        boolean bool = false;
        boolean result = instance.checkDateOfBirthFormat("22042000");
        assertEquals(bool,result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testcheckSpec() {
        System.out.println("checkSpec");
        valid instance = new valid();       
        boolean result = instance.checkSpecialization("abcdzyz");     
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testcheckLongerSpec() {
        System.out.println("checkLongerSpec");
        valid instance = new valid();       
        boolean result = instance.checkName("dfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfdef");     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testcheckBoundSpec() {
        System.out.println("checkLongerSpec");
        valid instance = new valid();       
        boolean result = instance.checkName("dfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdsfsdfsdfsdfdsfsdf");     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testInvalidAvai() {
        System.out.println("checkAvai");
        valid instance = new valid();       
        boolean result = instance.checkInt(0,3,4);     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testPositiveInvalidAvai() {
        System.out.println("checkAvai");
        valid instance = new valid();       
        boolean result = instance.checkInt(0,3,-1);     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testvalidAvai() {
        System.out.println("checkAvai");
        valid instance = new valid();       
        boolean result = instance.checkInt(0,3,2);     
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
     @Test
    public void testvalidBoundAvai() {
        System.out.println("checkBoundAvai");
        valid instance = new valid();       
        boolean result = instance.checkInt(0,3,3);     
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
      @Test
    public void testValidEmail() {
        System.out.println("checkEmail");
        valid instance = new valid();       
        boolean result = instance.checkEmailFormat("abc@gmail.com");     
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
      @Test
    public void testInvalidEmail() {
        System.out.println("checkEmail");
        valid instance = new valid();       
        boolean result = instance.checkEmailFormat("abcde");     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCharacterPhoneNum() {
        System.out.println("checkPhoneNumberAllCharacter");
        valid instance = new valid();       
        boolean result = instance.checkPhoneNumberFormat("abcdefghjk");     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testValidPhoneNum() {
        System.out.println("checkPhoneNumber");
        valid instance = new valid();       
        boolean result = instance.checkPhoneNumberFormat("1234567890");     
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testPhoneNumLarger() {
        System.out.println("checkPhoneNumberLarger");
        valid instance = new valid();       
        boolean result = instance.checkPhoneNumberFormat("12345678901");     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testPhoneNumLess() {
        System.out.println("checkPhoneNumberLess");
        valid instance = new valid();       
        boolean result = instance.checkPhoneNumberFormat("123456789");     
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of add method, of class process.
     */
    
}
