package me.zeman.springbootdemo2.business;

public class ShoppingCart {

    int dollars;

    public ShoppingCart(int value){
        dollars = value;
    }

    public int getTotalValue(){
        return dollars * 10;
    }

    public int notUser(){
        return dollars * 10;
    }

}
