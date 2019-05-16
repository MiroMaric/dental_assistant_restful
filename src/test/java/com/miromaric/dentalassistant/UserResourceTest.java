//package com.miromaric.dentalassistant;
//
//import com.miromaric.dentalassistant.model.User;
//import java.io.IOException;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.core.Application;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.glassfish.jersey.server.ResourceConfig;
//import org.glassfish.jersey.test.JerseyTest;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
///**
// *
// * @author MikoPC
// */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UserResourceTest extends JerseyTest {
//
//    private static ObjectMapper mapper;
//    private static User user;
//    private static User newUser;
//    
//    @BeforeClass
//    public static void setUpBeforeClass() {
//        mapper = new ObjectMapper();
//        user = new User("pera", "pera123pera", "pera@gmail.com", "pera", "peric", "pera bb", "0631234567");
//        newUser = new User("pera", "pera123pera", "pera@gmail.com", "pera", "peric", "pera bb", "0631234567");
//    }
//
//    @Override
//    protected Application configure() {
//        return new ResourceConfig(UserResource.class);
//    }
//    //*******
//    //POST
//    //*******
//    @Test
//    public void stage1_successSaveTest() throws IOException {
//        Response response = target().path("users").request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
//        Assert.assertEquals(201,response.getStatus());
//        Assert.assertEquals(
//                mapper.writeValueAsString(user),
//                mapper.writeValueAsString(mapper.readValue(mapper.readTree(response.readEntity(String.class)).get("data"), User.class))
//        );
//    }
//    
//    @Test
//    public void stage2_alreadyExistsSaveTest() throws IOException {
//        Response response = target().path("users").request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
//        Assert.assertEquals(400,response.getStatus());
//    }
//    
//    @Test
//    public void stage2_wrongFormatSaveTest() throws IOException {
//        User wrongFormatUser = new User("wrongPera", "pera123", "pera.com", "pera", "peric", "pera bb", "0631234567");
//        Response response = target().path("users").request().post(Entity.entity(wrongFormatUser, MediaType.APPLICATION_JSON));
//        Assert.assertEquals(400,response.getStatus());
//    }
//    
//        
//    @Test
//    public void stage3_successGetOneTest() throws IOException {
//        Response response = target().path("users/"+user.getUsername()).request().get();
//        Assert.assertEquals(200,response.getStatus());
//        Assert.assertEquals(
//                mapper.writeValueAsString(user),
//                mapper.writeValueAsString(mapper.readValue(mapper.readTree(response.readEntity(String.class)).get("data"), User.class))
//        );
//    }
//    
//    @Test
//    public void stage4_successGetAllTest() {
//        Response response = target().path("users/"+user.getUsername()).request().get();
//        Assert.assertEquals(200, response.getStatus());
//        Assert.assertNotNull(response.getEntity());
//    }
//    
//    @Test
//    public void stage5_successUploadTest() throws IOException{
//        Response response = target().path("users/"+user.getUsername()).request().put(Entity.entity(newUser, MediaType.APPLICATION_JSON));
//        Assert.assertEquals(200,response.getStatus());
//        Assert.assertEquals(
//                mapper.writeValueAsString(newUser),
//                mapper.writeValueAsString(mapper.readValue(mapper.readTree(response.readEntity(String.class)).get("data"), User.class))
//        );
//    }
//    
//    @Test
//    public void stage6_successDeleteTest() throws IOException{
//        Response response = target().path("users/"+newUser.getUsername()).request().delete();
//        Assert.assertEquals(200,response.getStatus());
//        Assert.assertEquals(
//                mapper.writeValueAsString(newUser),
//                mapper.writeValueAsString(mapper.readValue(mapper.readTree(response.readEntity(String.class)).get("data"), User.class))
//        );
//    }
//    
//    @Test
//    public void stage7_wrongFormatSaveTest() throws IOException {
//        Response response = target().path("users").request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
//        Assert.assertEquals(400,response.getStatus());
//        Assert.assertEquals(
//                mapper.writeValueAsString(user),
//                mapper.writeValueAsString(mapper.readValue(mapper.readTree(response.readEntity(String.class)).get("data"), User.class))
//        );
//    }
//}
