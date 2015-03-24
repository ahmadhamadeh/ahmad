package Servlet;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

public class UploadServletTest {


    private HttpServletResponse responseMock;
    private HttpServletRequest requestMock;

    @Before
    public void setUp(){
        responseMock = mock(HttpServletResponse.class);
        requestMock = mock(HttpServletRequest.class);
    }


}
