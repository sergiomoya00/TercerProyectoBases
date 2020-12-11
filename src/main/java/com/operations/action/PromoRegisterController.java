/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.operations.action;

import bean.Promo;
import com.opensymphony.xwork2.ActionSupport;
import dao.QueriesDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author HP ZBOOK 15 G3 i7
 */
@Results({
    @Result(name = "success", location = "/JSP/ProductPromotion.jsp")
    ,
   @Result(name = "input", location = "/JSP/ProductPromotion.jsp")
})

public class PromoRegisterController extends ActionSupport {

    private Promo promo = new Promo();
    private List productName = new ArrayList();

    @Override

    @Action(value = "/comboProducts")
    public String execute() {
        setProductName(this.productName);
        return SUCCESS;
    }

    @Action(value = "/addPromo")
    public String productRegister() {
        QueriesDAO q = new QueriesDAO();
        q.insertPromo(promo.getName(), promo.getDescription(), promo.getItemName(), promo.getDiscount(), promo.getRegist(), promo.getInitialDate(), promo.getFinalDate());
        return SUCCESS;

    }

    public List getProductName() {
        return productName;
    }

    public void setProductName(List productName) {
        QueriesDAO q = new QueriesDAO();
        for(int i=0;i<q.getAllProducts().size();i++){
        productName.add(q.getAllProducts().get(i));
                }
    }

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

}
