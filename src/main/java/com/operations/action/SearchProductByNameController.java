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
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author HP ZBOOK 15 G3 i7
 */

@Results({
    @Result(name = "success", location = "/JSP/SearchProduct.jsp")
    ,
   @Result(name = "input", location = "/JSP/SearchProduct.jsp")
})

public class SearchProductByNameController extends ActionSupport{
    
    private Item item=new Item();
    private List<Item> list;
    
     @Override
    public String execute() {
        return SUCCESS;
    }

    @Action(value = "/productlist")
    public String productList() {
        QueriesDAO q=new QueriesDAO();
        list=q.getProductByName(item.getName());
        return SUCCESS;

    }
    
     public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
    
}
