package priyanka.javaupgradesexamples.mockitodemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import priyanka.javaupgradesexamples.CalculatorService;
import priyanka.javaupgradesexamples.MathApplication;
import priyanka.javaupgradesexamples.Calculator;

//Attaches a runner to the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathAppTesterMockito1 {
	
	private MathApplication mathApp;
	private CalculatorService calcService;
	//private Calculator calc;
	private InOrder inOrder;
	
	//JUnit executes this before running the test case to do initial setting
	@Before
	public void setUp() {
		mathApp = new MathApplication();
		//mock() creates mock which is also done by @mock annotation
		//calc  = new Calculator();
		calcService = mock(CalculatorService.class);
		//calcService = spy(calc); --- returns the actuals object instance
		mathApp.setCalculatorService(calcService);
		 inOrder = inOrder(calcService);
		 
		
	}
	
	@Test
	public void testMathApp() {
		
		when(calcService.add(10.0, 20.0)).thenReturn(30.0);
		when(calcService.substract(20.0, 10.0)).thenReturn(10.0);
		
		//Behavior driven development- use of given, when and then
		//BDD given
		given(calcService.divide(2.0,1.0)).willReturn(2.0);
		//BDD when
		double result = calcService.divide(2.0,1.0);
		
		when(calcService.multiply(2.0,1.0)).thenAnswer(new Answer<Double>() {
		   @Override
		   public Double answer(InvocationOnMock invocation) throws Throwable {
		      //get the arguments passed to mock
		      Object[] args = invocation.getArguments();
		      //get the mock 
		      Object mock = invocation.getMock();	
		      //return the result
		      return 2.0;
		   }
		});
		
		//reset(calcService); //Resets the mock obeject
		
		assertEquals(mathApp.add(10.0, 20.0),30.0,0);
		assertEquals(mathApp.substract(20.0, 10.0),10.0,0);
		assertEquals(mathApp.multiply(2.0, 1.0),2.0,0);
		//BDD - then
		assertEquals(result,2.0,0);
		
	      //verify call to calcService is made or not
		  //timeout is used to test if a method is called within stipulated time frame.
	      verify(calcService,timeout(100)).add(10.0,20.0); 
	      verify(calcService).substract(20.0,10.0);
	      verify(calcService).multiply(2.0,1.0);
	      
	      inOrder.verify(calcService).add(10.0,20.0);
	      inOrder.verify(calcService).substract(20.0,10.0);
	      
	}
}
