package TestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.mycom.controller.SkillController;
import com.mycom.entity.Skill;
import com.mycom.jdbc.JdbcSkillDao;

@RunWith(MockitoJUnitRunner.class)
public class SkillControllerTest {
	
	@Mock
    private JdbcSkillDao dao;
    
	@InjectMocks
    private SkillController controller;
    
	private Skill skill;
	private List<Skill> skills;
	
	@Before
	public void initData() {
		skill = new Skill();
		skill.setName("Java");
		skills = new LinkedList<Skill>();
		skills.add(skill);
	}
	
	
	@Test
	public void getSkillsTest() {
		when(dao.findAll()).thenReturn(skills);
		assertEquals(controller.getSkills(),skills);
	}
	
	@Test
	public void SkillDeleteTest() {
		controller.SkillDelete(skill.getName());
	}
	
	@Test(expected = BindException.class)
	public void SaveSkillTestWithError() throws BindException{
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(true);
        assertEquals(controller.SaveSkill(skill, result),new BindException(result));
	}
	
	@Test
	public void SaveSkillTestWithoutError() throws BindException {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(false);
        assertEquals(controller.SaveSkill(skill, result),skill);
	}
	
	@Test
	public void SkillSortTest() {
		when(dao.sortSkill()).thenReturn(skills);
		assertEquals(controller.SkillSort(),skills);
	}
}
