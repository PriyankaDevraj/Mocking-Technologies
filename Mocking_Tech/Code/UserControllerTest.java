package priyanka.javaupgradesexamples.powermock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import priyanka.javaupgradesexamples.powermockdemo.DefaultUserService;
import priyanka.javaupgradesexamples.powermockdemo.User;
import priyanka.javaupgradesexamples.powermockdemo.UserController;


@RunWith(PowerMockRunner.class)
@PrepareForTest(UserController.class)

public class UserControllerTest {

	private DefaultUserService mockUserService;
	private UserController userController;
	private User user;

	@Test
	public void testGetUserCount() {

		mockUserService = EasyMock.createMock(DefaultUserService.class);

		EasyMock.expect(mockUserService.getUserCount()).andReturn(100L);
		EasyMock.replay(mockUserService);
		userController = new UserController(mockUserService);
		assertEquals(100L, userController.getUserCount().longValue());
	}
	@Test
	public void testMockStatic() throws Exception{
		user = new User();
		PowerMock.mockStaticPartial(UUID.class, "randomUUID");
		EasyMock.expect(UUID.randomUUID()).andReturn(UUID.fromString("067e6162-3b6f-4ae2-a171-2470b63dff00"));
		PowerMock.replayAll();
		UserController userController = new UserController();
		assertTrue(userController.createUserId(user).contains("067e6162-3b6f-4ae2-a171-2470b63dff00"));
		PowerMock.verifyAll();
	}
	

}
