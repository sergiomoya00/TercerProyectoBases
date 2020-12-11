/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.operations.action;

import bean.Item;
import bean.SystemManager;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.QueriesDAO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author HP ZBOOK 15 G3 i7
 */
@Results({
    @Result(name = "success", location = "/JSP/AddProduct.jsp")
    ,
   @Result(name = "input", location = "/JSP/AddProduct.jsp")
})

public class ProductRegisterController extends ActionSupport {
    
    private Item item=new Item();
    
     @Override
    public String execute() {
        return SUCCESS;
    }

    @Action(value = "/addProduct")
    public String productRegister() {
        QueriesDAO q=new QueriesDAO();
        q.insertProduct(item.getName(), item.getBrand(), item.getPrice(), SystemManager.getInstance().getSport(), item.isLimitedEdition(), item.getAvailableItems(), item.getImage(), item.getType());
        SystemManager.getInstance().removeSport();
        return SUCCESS;

    }
    
    @Action(value = "/addSport")

    public String addSport() {
        SystemManager.getInstance().addSport(item.getSport());
        return SUCCESS;

    }
    
     public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
}
