package priyanka.javaupgradesexamples.powermock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import priyanka.javaupgradesexamples.powermockdemo.ServiceHolder;

@RunWith(PowerMockRunner.class)
public class TestAddService {
	@Test
	public void testAddService() throws Exception {
		ServiceHolder tested = new ServiceHolder();
		final Object service = new Object();
		final Object service1 = new Object();

		tested.addService(service);
		tested.addService(service1);

	        // This is how you get the private services set using PowerMock
		Set<String> services = Whitebox.getInternalState(tested,"services");
		
		
		assertEquals("Size of the \"services\" Set should be 2", 2, services
				.size());
		assertSame("The services Set should didn't contain the expect service",
				service, services.iterator().next());
	}
}
