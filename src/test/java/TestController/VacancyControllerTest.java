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
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.mycom.controller.VacancyController;
import com.mycom.entity.Vacancy;
import com.mycom.jdbc.JdbcVacancyDao;

@RunWith(MockitoJUnitRunner.class)
public class VacancyControllerTest {
	
	@Mock
	private JdbcVacancyDao dao;
	
	@InjectMocks
	private VacancyController controller;
	
	private Vacancy vacancy;
	private Vacancy updateVacancy;
	
	private List<Vacancy> vacancys;
	
	@Before
	public void InitData() {
		vacancy = new Vacancy();
		vacancy.setExperienceYearRequire(3);
		vacancy.setIdDeveloper(1);
		vacancy.setPosition("fdsfsdfsd");
		vacancy.setSalaryfrom(1223);
		vacancy.setSalaryto(2123);
		
		updateVacancy = new Vacancy();
		updateVacancy.setExperienceYearRequire(3);
		updateVacancy.setId(1L);
		updateVacancy.setPosition("dfsfsdfsd");
		updateVacancy.setSalaryfrom(1213);
		updateVacancy.setSalaryto(2134);
		updateVacancy.setIdDeveloper(2);
		
		vacancys = new LinkedList<Vacancy>();
		vacancys.add(vacancy);
	}
	
	@Test
	public void vacancyAllTest() {
		when(dao.findAll()).thenReturn(vacancys);
		assertEquals(controller.VacancyAll(),vacancys);
	}
	
	@Test
	public void vacancyDeleteTest() {
		controller.VacancyDelete(updateVacancy.getId());
	}
	
	@Test(expected = BindException.class)
	public void vacancySaveOrUpdateWithError() throws BindException {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(true);
        assertEquals(controller.SaveVacancy(vacancy,result),vacancy);
	}
	
	@Test
	public void vacancySaveOrUpdate() throws BindException {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(false);
        assertEquals(controller.SaveVacancy(vacancy, result),vacancy);
        assertEquals(controller.SaveVacancy(updateVacancy, result),updateVacancy);
	}
	
	@Test
	public void vacancySortSalaryTo() {
		when(dao.sortForSalaryTo()).thenReturn(vacancys);
		assertEquals(controller.VacancySortSalaryTo(),vacancys);
	}
	
	@Test
	public void vacancySortSalaryFrom() {
		when(dao.sortForSalaryFrom()).thenReturn(vacancys);
		assertEquals(controller.VacancySortSalaryFrom(),vacancys);
	}
	
	@Test
	public void vacancySortExperience() {
		when(dao.sortForExperience()).thenReturn(vacancys);
		assertEquals(controller.SortExperience(),vacancys);
	}
}
