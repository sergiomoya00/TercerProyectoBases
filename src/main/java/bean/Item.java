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
public class Item {
    private String name;
    private String brand;
    private int price;
    private ItemSport sport;
    private boolean limitedEdition;
    private int availableItems;
    private String image;
    private String type;
 
    public Item(String name, String brand, int price, ItemSport sport, boolean limitedEdition, int availableItems, String image, String type) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.sport = sport;
        this.limitedEdition = limitedEdition;
        this.availableItems = availableItems;
        this.image = image;
        this.type = type;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemSport getSport() {
        return sport;
    }

    public void setSport(ItemSport sport) {
        this.sport = sport;
    }

    public boolean isLimitedEdition() {
        return limitedEdition;
    }

    public void setLimitedEdition(boolean limitedEdition) {
        this.limitedEdition = limitedEdition;
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
