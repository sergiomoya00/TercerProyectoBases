/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author HP ZBOOK 15 G3 i7
 */
public class prueba {

    public static void main(String[] args) {
        QueriesDAO q = new QueriesDAO();
        //System.out.print(q.getProductByName("Pantalones").get(0));
        UsuariosDao dao = new UsuariosDao();
        //dao.sameProduct("mata");

        //q.updateProductQuantity("guantes", 2);
        List lol = new ArrayList<>();
        lol.add("guantes");
        lol.add(2);
        lol.add("Tacos");
        lol.add(5);
        lol.add("Gorra verde");
        lol.add(7);

        //q.createCarrito("jose1", lol);
        //System.out.print(q.getProductsCarrito("jose1"));
        //System.out.print(q.updatedProductsList(lol, "guantes"));
        //q.deleteProductCarrito("jose1", "guantes");
        q.updateProductPrice("Guantes");
    }

}
