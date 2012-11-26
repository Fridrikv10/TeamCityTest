package test;

import jonas.MathD;
import junit.framework.*;

public class TestMath extends TestCase { 

    private MathD mathD = new MathD();

  protected void setUp() { 
    	
  	// put common setup code in here
   }
   
  protected void tearDown() {
  	
  	// put common cleanup code in here
  }
    
  public void testAdd() {
  	int num1 = 3;
  	int num2 = 2;
  	int total = 5;
  	int sum = 0;
  	sum = mathD.add(num1, num2);
  	assertEquals(sum, total);
  }
  
  public void testMulitply() {
  	
  	int num1 = 3; 
  	int num2 = 7; 
  	int total = 21;
  	int sum = 0;
  	sum = mathD.multiply(num1, num2);
  	assertEquals("Problem with multiply", sum, total);
  	
  	
  	num1 = 5;
  	num2 = 4;
  	total = 20;
  	sum = mathD.multiply(num1, num2);
  	assertEquals("Problem with multiply", sum, total);
  	
  }
    
}