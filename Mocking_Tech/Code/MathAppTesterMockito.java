package priyanka.javaupgradesexamples.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import priyanka.javaupgradesexamples.CalculatorService;
import priyanka.javaupgradesexamples.MathApplication;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathAppTesterMockito {

	// @InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	MathApplication mathApp = new MathApplication();

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;

	@Test
	public void testCalc() {
	
				
		when(calcService.add(10.0, 20.0)).thenReturn(30.0);
		when(calcService.substract(20.0, 10.0)).thenReturn(10.0);
		when(calcService.multiply(2.0, 2.0)).thenReturn(4.0);
		when(calcService.divide(20.0, 10.0)).thenReturn(2.0);
		
		
		
		assertEquals(mathApp.add(10.0, 20.0),30.0,0);
		assertEquals(mathApp.substract(20.0, 10.0),10.0,0);
		assertEquals(mathApp.multiply(2.0, 2.0),4.0,0);
		assertEquals(mathApp.divide(20.0, 10.0),2.0,0);
		
		
		verify(calcService,times(1)).add(10.0, 20.0);
		verify(calcService,atMost(2)).substract(20.0,10.0);
		verify(calcService,atLeastOnce()).multiply(2.0,2.0);
		verify(calcService,atMost(2)).divide(20.0, 10.0);
		verify(calcService,never()).divide(30.0, 10.0);
	}

}
