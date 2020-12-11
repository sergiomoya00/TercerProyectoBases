/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

/**
 *
 * @author HP ZBOOK 15 G3 i7
 */
public class SystemManager {

    List<String> sports = new SimpleLinkeList<>();;
    List<String> temp = new SimpleLinkeList<>();

    public static SystemManager instance;

    public static final SystemManager getInstance() {
        return instance;
    }

    static {
        instance = new SystemManager();
        instance.sports.add("hola");

        instance.sports.clear();
        //instance.partitions.clear();
    }

    public void addSport(String hdd) {
        this.sports.add(hdd);
    }

    public void removeSport() {
        this.sports.clear();
    }

    public List<String> getSport() {
        return sports;
    }
    
     public void addName(String hdd) {
        this.temp.add(hdd);
    }

    public void removeName() {
        this.temp.clear();
    }

    public List<String> getName() {
        return temp;
    }
}
