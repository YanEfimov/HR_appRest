package TestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.mycom.controller.InterviewController;
import com.mycom.entity.Interview;
import com.mycom.service.InterviewService;

@RunWith(MockitoJUnitRunner.class)
public class InterviewControllerTest {

    @Mock
    private InterviewService service;

    @InjectMocks
    private InterviewController controller;

    private Interview interview;
    private Interview interviewUp;
    private List<Interview> interviews;

    @Before
    public void initData() {
        MockitoAnnotations.initMocks(this);

        interview = new Interview();
        interview.setId(new Long(1));
        interview.setFactDate(new Date());
        interview.setPlanDate(new Date());
        //interview.setIdVacancy(1L);
        //interview.setIdCandidate(1L);
        interview.setName("name");

        interviewUp = new Interview();
        interviewUp.setFactDate(new Date());
        interviewUp.setPlanDate(new Date());
        //interviewUp.setIdVacancy(1L);
        //interviewUp.setIdCandidate(1L);
        interviewUp.setName("name");

        interviews = new LinkedList<Interview>();
        interviews.add(interview);
    }
    @Test
    public void InterviewDeleteTest() {
        controller.InterviewDelete(interview.getId());
    }

    @Test
    public void interviewAllTest() {
        when(service.findAll()).thenReturn(interviews);
        assertEquals(controller.InterviewAll(),interviews);
    }


    @Test(expected = BindException.class)
    public void SaveInterviewTestWithError() throws BindException{
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(true);
        assertEquals(controller.SaveInterview(interview, result),new BindException(result));
    }

    @Test
    public void SaveInterviewTestWithoutError() throws BindException {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(false);
        assertEquals(controller.SaveInterview(interview, result),interview);
        assertEquals(controller.SaveInterview(interviewUp, result), interviewUp);
    }

    @Test
    public void InterviewSortTest() {
        when(service.sort("name")).thenReturn(interviews);
        assertEquals(controller.Sort("name"),interviews);
    }
}
