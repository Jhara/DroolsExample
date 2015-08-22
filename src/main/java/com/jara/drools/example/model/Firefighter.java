/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jara.drools.example.model;


public class Firefighter {

    private String name;

    public Firefighter() {
    }

    public Firefighter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Firefighter[name= '"+name+"']";
    }




}
