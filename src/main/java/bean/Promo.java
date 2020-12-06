/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author samoy
 */
public class Promo {

    private String name;
    private String description;
    private Item itemName;
    private String discount;
    private String initialDate;
    private String finalDate;

    public Promo(String name, String description, Item itemName, String discount, String initialDate, String finalDate) {
        this.name = name;
        this.description = description;
        this.itemName = itemName;
        this.discount = discount;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    public Promo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item getItemName() {
        return itemName;
    }

    public void setItemName(Item itemName) {
        this.itemName = itemName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }
    
    
}
