package Servlet;

import Controller.DatabaseController;
import org.junit.Before;
import org.lightcouch.CouchDbClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

public class UploadServletTest {


    private HttpServletResponse responseMock;
    private HttpServletRequest requestMock;
    private CouchDbClient dbClientMock;
    private DatabaseController dbControllerMock;

    @Before
    public void setUp() {
        responseMock = mock(HttpServletResponse.class);
        requestMock = mock(HttpServletRequest.class);
        dbClientMock = mock(CouchDbClient.class);
        dbControllerMock = mock(DatabaseController.class);
    }

}
