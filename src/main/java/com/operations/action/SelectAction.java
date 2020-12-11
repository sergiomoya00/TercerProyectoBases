/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.operations.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
    @Result(name = "success", location = "/JSP/AddProduct.jsp")
    ,@Result(name = "fail", location = "/JSP/AddProduct.jsp")
})

public class SelectAction extends ActionSupport {

    private List state = new ArrayList();
    private List status = new ArrayList();
    
    @Action(value = "/addProduct")
    public String execute()
    {
        setState(this.state);
        
        return "success";
    }
     
    //getter and setter method for state variable//
    public List getState() {
        return state;
    }
 
    public void setState(List state) {        
    //Here for displaying the data on UI, we are using few hardcoded values//
        state.add("Defect"); 
        state.add("Task");
        state.add("User Stories");
    }
 
    public List getStatus() {
        return status;
    }
    
    
    public void setStatus(List status) {
         
        status.add("New"); 
        status.add("Fixed");
        status.add("Resolved");
        status.add("Closed");
       
    }
    
    
   

}
