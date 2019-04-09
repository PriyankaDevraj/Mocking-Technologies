package priyanka.javaupgradesexamples.powermock;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import priyanka.javaupgradesexamples.Calculator;

@RunWith(PowerMockRunner.class)
public class TestCalculator {
	@Test
	public void testAddService() throws Exception {

		Calculator cal = new Calculator();
		Calculator cal1 = Whitebox.invokeConstructor(Calculator.class, 10);
		int sum = Whitebox.<Integer> invokeMethod(cal1, "add", 1, 2,3);
		int sum1 = Whitebox.<Integer> invokeMethod(cal, "add", 10,20);
		
		assertEquals(6,sum);
		assertEquals(30,sum1);
		

	}
}
