package TestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.mycom.controller.UserController;
import com.mycom.entity.User;
import com.mycom.jdbc.JdbcUserDao;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	@Mock
    private JdbcUserDao dao;
    
	@InjectMocks
    private UserController controller;
	
	private User user;
	private User updateUser;
	private List<User> users;
	
	@Before
	public void initData() {
		MockitoAnnotations.initMocks(this);
		
		user = new User();
		user.setEmail("yan.efimov@gmail.com");
		user.setName("Yan");
		user.setSurname("Efimov");
		user.setRole("developer");
		user.setPassword("124rffscxvxcczxczx");
		
		users = new LinkedList<User>();
		users.add(user);
		
		updateUser = new User();
		updateUser.setId(1L);
		updateUser.setEmail("yan.efimov@gmail.com");
		updateUser.setName("Yan");
		updateUser.setSurname("Efimov");
		updateUser.setRole("developer");
		updateUser.setPassword("2ewdsfdcvxcczx");
	}
	
	@Test
	public void deleteUserTest() {
		controller.UserDelete(updateUser.getId());
	}
	
	@Test(expected = BindException.class)
	public void UserSaveOrUpdateWithErrorTest() throws BindException {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(true);
        assertEquals(controller.SaveUser(user, result),new BindException(result));
	}
	
	@Test
	public void UserSaveOrUpdate() throws BindException {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(false);
        assertEquals(controller.SaveUser(user, result),user);
        assertEquals(controller.SaveUser(updateUser, result),updateUser);
	}
	
	@Test
	public void UserAllTest() {
		when(dao.findAll()).thenReturn(users);
		assertEquals(controller.UserAll(),users);
	}
	
	@Test
	public void UserFilterTest() {
		when(dao.findByRole(user.getRole())).thenReturn(users);
		assertEquals(controller.FilterUser(user.getRole()),users);
	}
	
	@Test
	public void UserSortNameTest() {
		when(dao.findAllSortName()).thenReturn(users);
		assertEquals(controller.UserSortName(),users);
	}
}
