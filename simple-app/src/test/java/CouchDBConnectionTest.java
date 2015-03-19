import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.DocumentConflictException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CouchDBConnectionTest {
    @Test
    public void connectionTest(){
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("simple-app")
                .setCreateDbIfNotExist(true)
                .setProtocol("https")
                .setHost("couchdb40155-env-8900677.jelastic.elastx.net")
                .setPort(443)
                .setUsername("admin")
                .setPassword("admin")
                .setMaxConnections(100)
                .setConnectionTimeout(0);

        CouchDbClient dbClient = new CouchDbClient(properties);

        JsonObject jsonObject = dbClient.find(JsonObject.class, "123");
        if(jsonObject == null) {
            JsonObject json = new JsonObject();

            json.addProperty("_id", "123");
            json.addProperty("appname", "simple-app");
            json.add("array", new JsonArray());
            dbClient.save(json);
        }
        jsonObject = dbClient.find(JsonObject.class, "123");

        assertNotNull(jsonObject);
        assertNotNull(jsonObject.get("appname"));
        assertEquals(jsonObject.get("appname").getAsString(), "simple-app");
        dbClient.shutdown();

    }
}
