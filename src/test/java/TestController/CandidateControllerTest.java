package TestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import com.mycom.controller.CandidateController;
import com.mycom.entity.Candidate;
import com.mycom.jdbc.JdbcCandidateDao;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;



@RunWith(MockitoJUnitRunner.class)
public class CandidateControllerTest {

    @Mock
    private JdbcCandidateDao dao;

    @InjectMocks
    private CandidateController controller;

    private Candidate candidate;
    private Candidate candidate1;
    private List<Candidate> candidates;

    @Before
    public void initData() {
        MockitoAnnotations.initMocks(this);

        candidate = new Candidate();
        candidate.setId(new Long(1));
        candidate.setName("Kate");
        candidate.setSurname("Sigaeva");
        candidate.setBirthday(new DateTime("1998-09-09"));
        candidate.setSalary(3000.0);
        candidate.setCandidateState("active");

        candidate1 = new Candidate();
        candidate1.setName("Serj");
        candidate1.setSurname("Grom");
        candidate1.setBirthday(new DateTime("1999-08-12"));
        candidate1.setSalary(100.0);
        candidate1.setCandidateState("passive");

        candidates = new LinkedList<Candidate>();
        candidates.add(candidate);
    }
    @Test
    public void CandidateDeleteTest() {
        controller.CandidateDelete(candidate.getId());
    }
    @Test
    public void CandidateFilterTest() {
        controller.CandidateFilter("active");
        when(dao.findByState("active")).thenReturn(candidates);
        assertEquals(controller.CandidateFilter("active"), candidates);
    }

    @Test
    public void CandidateAllTest() {
        when(dao.findAll()).thenReturn(candidates);
        assertEquals(controller.CandidateList(),candidates);
    }


    @Test(expected = BindException.class)
    public void SaveCandidateTestWithError() throws BindException{
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(true);
        assertEquals(controller.SaveOrUpdate(candidate, result),new BindException(result));
    }

    @Test
    public void SaveCandidateTestWithoutError() throws BindException {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(false);
        assertEquals(controller.SaveOrUpdate(candidate1, result), candidate1);
        assertEquals(controller.SaveOrUpdate(candidate, result), candidate);
    }

    @Test
    public void CandidateSortNameTest() {
        when(dao.sortNameCandidate()).thenReturn(candidates);
        assertEquals(controller.CandidateSortName(),candidates);
    }
    @Test
    public void CandidateSortSalaryTest() {
        when(dao.sortSalaryCandidate()).thenReturn(candidates);
        assertEquals(controller.CandidateSortSalary(),candidates);
    }
}
