package eetac.dsa.lab;

import eetac.dsa.lab.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carlos on 19/04/2017.
 */
@Path("")
public class EetakemonService {

    private static Map<Integer,User> userList = new HashMap<Integer, User>();

    @POST
    @Path("/add")  //Add user
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User u) {
        try {
            u.insert();
            return Response.status(201).entity("User added successfully: " + u).build();
        } catch (Exception u1) {
            u1.printStackTrace();
            return Response.status(409).entity("User already exists!").build();
        }
    }


    @GET
    @Path("/all")  //List user
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUser() throws Exception {
        User u = new User();
        List<User> list = u.findAll();
        return list;
    }


    @GET
    @Path("/name/{name}")  //Find by name
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> searchByName (@PathParam("name") String name) throws Exception {
        User u = new User (null,name,null);
        List<User> list = u.selectByName();
        return list;
    }

    @POST
    @Path("/modify")  //Modify user
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User u) {
        try {
            u.update();
            return Response.status(201).entity("User modified successfully: " + u).build();
        } catch (Exception e1) {
            e1.printStackTrace();
            return Response.status(409).entity("User not modified!").build();
        }
    }

    @GET
    @Path("/consultarobjeto/{name}")  //Consultar objeto usuario
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> searchObjectByName (@PathParam("name") String name) throws Exception {
        User u = new User (null,name,null);
        List<User> list = u.selectByName();
        return list;
    }

    @POST
    @Path("/añadirobjeto/{name}")  //Añadir objeto a usuario
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateObjectUser(User u) {
        try {
            u.update();
            return Response.status(201).entity("Object added successfully: " + u).build();
        } catch (Exception e1) {
            e1.printStackTrace();
            return Response.status(409).entity("Error!").build();
        }
    }
}
