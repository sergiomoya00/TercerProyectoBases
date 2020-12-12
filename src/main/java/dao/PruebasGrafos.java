/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Item;
import bean.User;
import org.neo4j.driver.*;

import static org.neo4j.driver.Values.parameters;

public class PruebasGrafos
{
    

    public static void main(String... args)
    {
        UsuariosDao daoE = new  UsuariosDao();
        //AGREGA EL USUARIO NO TIENE UNIQUE
        User usuario1 = new User("Alberto", "Mata", "M", "1999", "mata", "1234");
        daoE.addUser(usuario1);
        //AGREGA ITEM INICIALIZAR OBJETO EN AMBOS
        Item item1 = new Item("NikeMetcon", "Nike", 100, "Crossfit", "no", "prenda de vestir");
        daoE.addItem(item1);
        daoE.close();
    }
}
