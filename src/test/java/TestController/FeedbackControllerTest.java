package TestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import com.mycom.controller.FeedbackController;
import com.mycom.entity.FeedBack;
import com.mycom.jdbc.JdbcFeedBackDao;
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
public class FeedbackControllerTest {

    @Mock
    private JdbcFeedBackDao dao;

    @InjectMocks
    private FeedbackController controller;

    private FeedBack feedBack;
    private FeedBack feedBack1;
    private List<FeedBack> feedBacks;

    @Before
    public void initData() {
        MockitoAnnotations.initMocks(this);

        feedBack = new FeedBack();
        feedBack.setId(new Long(1));
        feedBack.setFeedbackState("awaiting");
        feedBack.setIdInterview(1);
        feedBack.setIdInterviewer(1);
        feedBack.setReason("because");

        feedBack1 = new FeedBack();
        feedBack1.setFeedbackState("success");
        feedBack1.setIdInterview(2);
        feedBack1.setIdInterviewer(2);
        feedBack1.setReason("because");



        feedBacks = new LinkedList<FeedBack>();
        feedBacks.add(feedBack);
    }
    @Test
    public void FeedbackDeleteTest() {
        controller.FeedbackDelete(feedBack.getId());
    }

    @Test
    public void FeedBackAllTest() {
        when(dao.findAll()).thenReturn(feedBacks);
        assertEquals(controller.FeedBackAll(),feedBacks);
    }


    @Test(expected = BindException.class)
    public void SaveFeedbackTestWithError() throws BindException{
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(true);
        assertEquals(controller.SaveFeedback(feedBack, result),new BindException(result));
    }

    @Test
    public void SaveFeedbackTestWithoutError() throws BindException {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors())
                .thenReturn(false);
        assertEquals(controller.SaveFeedback(feedBack1, result),feedBack1);
        assertEquals(controller.SaveFeedback(feedBack, result), feedBack);
    }
    
    @Test
    public void FiterFeedBackTest() {
    	when(dao.findByState(feedBack.getFeedbackState())).thenReturn(feedBacks);
    	assertEquals(controller.FilterFeedBack(feedBack.getFeedbackState()),feedBacks);
    }

}
