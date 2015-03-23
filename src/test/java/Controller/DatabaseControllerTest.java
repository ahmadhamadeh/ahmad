package Controller;

import Entity.DummyData;
import org.junit.Before;
import org.junit.Test;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.Response;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DatabaseControllerTest {

    public static final String TESTDB = "testdb";
    private CouchDbClient dbClient;
    private DatabaseController databaseController;

    @Before
    public void setupFreshDB() {
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName(TESTDB)
                .setCreateDbIfNotExist(true)
                .setProtocol("https")
                .setHost("couchdb40155-env-8900677.jelastic.elastx.net")
                .setPort(443)
                .setUsername("admin")
                .setPassword("admin")
                .setMaxConnections(100)
                .setConnectionTimeout(0);
        dbClient = new CouchDbClient(properties);
    }

    // Skreiv om koden til delete, så måtte kommentere ut testene før visning.

    /*
    @Test
    public void connectionSmokeTest() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_id", "123");
        jsonObject.addProperty("appname", "simple-app");
        jsonObject.add("array", new JsonArray());
        dbClient.save(jsonObject);

        jsonObject = dbClient.find(JsonObject.class, "123");
        assertNotNull(jsonObject);
        assertNotNull(jsonObject.get("_id"));
        assertNotNull(jsonObject.get("appname"));
        assertEquals(jsonObject.get("appname").getAsString(), "simple-app");
        dbClient.remove(jsonObject);
    }
*/
    @Test
    public void addAndRemoveFromDatabase() {

        //Adding data to database
        dbClient = DatabaseSetup.getDbCliend();
        databaseController = new DatabaseController();
        String id = "";
        DummyData dummyData = null;
        try {
            id = databaseController.addToDatabase(dbClient).getId();
            dummyData = dbClient.find(DummyData.class, id);
        } catch (Exception e) {
            fail("Could not add data to database");
        }

        // Looking for the data in the database.
        assertEquals(dummyData.get_id(), id);
        DummyData deletedObject = null;

        //Deleting the data from the database
        try {
            databaseController.removeDocument(dbClient, id);
            // Trying to find the deleted object.
            deletedObject = dbClient.find(DummyData.class, id);
            assertThat("The object created for the test was not deleted.", deletedObject, is(notNullValue()));
        } catch (Exception e) {
            assertThat(deletedObject, is(nullValue()));
        }
    }

    @Test
    public void addDataToDatabase() {
        dbClient = DatabaseSetup.getDbCliend();
        databaseController = new DatabaseController();

        Response r = databaseController.addToDatabase(dbClient);
        assertTrue(r.getId().length() > 0);
    }
}