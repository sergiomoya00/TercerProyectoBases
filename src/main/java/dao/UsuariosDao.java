package dao;


import bean.Item;
import bean.User;
import java.util.ArrayList;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import static org.neo4j.driver.Values.parameters;
import org.neo4j.driver.*;
import static org.neo4j.driver.Values.parameters;
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
//METODO DE COMPRAR PRODUCTO, RECIBE EL NOMBRE DEL PRODUCTO Y EL NOMBRE DE USUARIO
public void buyItem(String userName,String itemName )
{
        try ( Session session = driver.session() )
        {
            session.run( "MATCH (a:Usuario {usuario: $nombreUsuario}) " +
                    "MATCH (p:Producto {nombre: $nombreProducto}) " +
                    "CREATE (a)-[:COMPRA]->(p)",
            parameters( "nombreUsuario", userName, "nombreProducto", itemName ) );
        }   
}    
    
//    HISTORIAL DE COMPRAS DEL USUARIO, RECIBE EL NOMBRE DE USUARIO
//            Y RETORNA UNA LISTA DE PRODUCTOS
    public ArrayList<Item> userRecord(String userName)
    {
        ArrayList<Item> itemList = new ArrayList<>();
        try (Session session = driver.session())
        {
            Result result = session.run(
                    "MATCH (n:Usuario {usuario: $x})-[r]-(b)\n" +
                        "RETURN b ",
                    parameters("x", userName));
            while (result.hasNext())
            {
                Record record = result.next();
                Item item = new Item(record.get(0).get("nombre").asString(), record.get(0).get("marca").asString(),
                        record.get(0).get("precio").asInt(), record.get(0).get("nombre").asString(),
                        record.get(0).get("nombre").asString(), record.get(0).get("nombre").asString());
                itemList.add(item);
                System.out.println(record.get(0).get("nombre"));
            }
        }
        return itemList;
    }
//RECIBE EL NOMBRE DEL ARTICULO Y RETORNA LA CANTIDAD DE VECES QUE FUE VENDIDO    
    public int itemSold(String itemName)
    {      
        int sold = 0;
        try (Session session = driver.session())
        {
            Result result = session.run(
                    "MATCH (p:Producto {nombre:$x})-[r:COMPRA]-() RETURN count(*) as count",
                    parameters("x", itemName));
            while (result.hasNext())
            {
                Record record = result.next();
                sold = record.get(0).asInt();
                System.out.println(sold);
            }
        }
        return sold;
    }
    
//DEVUELVE TRUE SI CONCUERDA EL USUARIO Y CONTRASENA    
    public boolean logIn(String userName, String passsword)
    {      
        boolean isSuccesfull = false;
        try (Session session = driver.session())
        {
            Result result = session.run(
                    "MATCH (n:Usuario{usuario: $nombreUsuario,contrasena:$contrasena}) RETURN n",
                    parameters("nombreUsuario", userName, "contrasena",passsword ));
            while (result.hasNext())
            {
                Record record = result.next();
                if (record.get(0) != null) {
                    isSuccesfull = true;
                }
            }
        }
        return isSuccesfull;
    }
//RETORNA FALSO SI NOOO EXISTE EL USUARIO SI DA TRUE ES QUE YA EXISTE
    public boolean uniqueUsername(String userName)
    {      
        boolean isSuccesfull = false;
        try (Session session = driver.session())
        {
            Result result = session.run(
                    "MATCH (n:Usuario{usuario: $nombreUsuario}) RETURN n",
                    parameters("nombreUsuario", userName));
            while (result.hasNext())
            {
                Record record = result.next();
                if (record.get(0) != null) {
                    isSuccesfull = true;
                }
            }
        }
        return isSuccesfull;
    }
    public void close()
    {
        // Closing a driver immediately shuts down all open connections.
        driver.close();
    }    
    
    
    
    
}
