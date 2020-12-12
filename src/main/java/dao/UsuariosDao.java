package dao;


import bean.Item;
import bean.User;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import static org.neo4j.driver.Values.parameters;
import org.neo4j.driver.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mata
 */
public class UsuariosDao {
 Driver driver;
    
    public UsuariosDao()
    {
        String uri = "bolt://35.229.22.8:7687";
        String user = "neo4j";
        String password = "fR3MLCPL1sbnL2Mv";       
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }
    public void addUser(User name)
    {
        // Sessions are lightweight and disposable connection wrappers.
        try (Session session = driver.session())
        {
            // Wrapping a Cypher Query in a Managed Transaction provides atomicity
            // and makes handling errors much easier.
            // Use `session.writeTransaction` for writes and `session.readTransaction` for reading data.
            // These methods are also able to handle connection problems and transient errors using an automatic retry mechanism.
            session.writeTransaction(tx -> tx.run("MERGE (a:Usuario {nombre: $n, apellido: $l, genero: $g, fechaNac: $f,"
                    + "usuario: $u, contrasena: $c})", 
                    parameters("n", name.getName(),"l", name.getLastName(),"g", name.getGender(),"f", name.getBirthDate()
                    ,"u", name.getUserName(),"c", name.getPassword())));
        }
    }
    public void addItem(Item item)
    {
       
        try (Session session = driver.session())
        {
            session.writeTransaction(tx -> tx.run("MERGE (p:Producto {nombre: $n, marca: $l, precio: $g, deporte: $f,"
                    + "tipo: $u, edicionLimitada: $c})", 
                    parameters("n", item.getName(),"l", item.getBrand(),"g", item.getPrice(),"f", item.getSport()
                    ,"u", item.getType(),"c", item.isLimitedEdition())));
        }
    }  
    public void close()
    {
        // Closing a driver immediately shuts down all open connections.
        driver.close();
    }    
    
    
    
    
}
