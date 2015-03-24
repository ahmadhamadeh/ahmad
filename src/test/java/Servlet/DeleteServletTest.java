package Servlet;

import Controller.DatabaseController;
import Controller.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by kim.flaethe on 23.03.2015.
 */
public class DeleteServletTest {

    private CouchDbClient dbClient;
    private DatabaseController dbController;
    private HttpServletResponse response;
    private HttpServletRequest request;

    @Before
    public void setUp(){
        dbClient = mock(CouchDbClient.class);
        dbController = mock(DatabaseController.class);
        response = mock(HttpServletResponse.class);
        request = mock(HttpServletRequest.class);
    }


    @Test
    public void doGetTest(){
        when(request.getParameter(anyString())).thenReturn(anyString());

        dbClient = DatabaseSetup.getDbCliend();

        dbController = new DatabaseController();


    }
}
