package eetac.dsa.lab.entity;
import eetac.dsa.lab.Dao;

/**
 * Created by Carlos on 19/04/2017.
 */
public class User extends Dao {
    private Integer id;
    private String name;
    private String password;

    public User()
    {
    }

    public User (Integer id, String name, String mail)
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public Integer getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
    }

    @Override
    public String getPrimaryKey() {
        return "id";
    }

    @Override
    public String getPKMethod() {
        return "getId";
    }
}