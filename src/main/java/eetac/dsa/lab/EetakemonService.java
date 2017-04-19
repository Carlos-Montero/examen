package eetac.dsa.lab;

import eetac.dsa.lab.entity.User;
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

    private static Map<Integer,User> eetakemonList = new HashMap<Integer, User>();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEetakemon(User u) {
        try {
            u.insert();
            return Response.status(201).entity("User added successfully: " + u).build();
        } catch (Exception e1) {
            e1.printStackTrace();
            return Response.status(409).entity("User already exists!").build();
        }
          /*
           {
             id: 3,
             code: "errot!
           }
         */
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listEetakemon() throws Exception {
        User u = new User();
        List<User> list = u.findAll();
        return list;
    }


    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> searchByName (@PathParam("name") String name) throws Exception {
        User u = new User(null,name,null);
        List<User> list = u.selectByName();
        return list;
    }

    @GET
    @Path("/{id}/delete")
    public Response delById(@PathParam("id") int id) {
        User u = new User(id,null,null);
        try {
            u.delete();
            return Response.status(200).entity("User deleted successfully.").build();
        } catch (Exception e1) {
            e1.printStackTrace();
            return Response.status(202).entity("User does not exists.").build();
        }
    }

    @POST
    @Path("/modify")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEetakemon(User u) {
        try {
            u.update();
            return Response.status(201).entity("User added successfully: " + u).build();
        } catch (Exception e1) {
            e1.printStackTrace();
            return Response.status(409).entity("User already exists!").build();
        }
    }
    /*
    {
       result: 202,
       msg: "aaaaa"
    }
*/
}
