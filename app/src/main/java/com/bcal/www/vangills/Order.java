package com.bcal.www.vangills;

public class Order {

    private Integer OrderID;
    private Integer CusID;
    private Integer noItems;

    public Order(){

    }



    public Integer getOrderID(){
        return OrderID;
    }

    public Integer getCusID(){
        return CusID;
    }

    public Integer getNoItems(){
        return noItems;
    }



    public void setOrderID(Integer OrderID){
        this.OrderID = OrderID;
    }

    public void setCusID(Integer CusID){
        this.CusID = CusID;
    }

    public void setNoItems(Integer noItems){
        this.noItems = noItems;
    }


}
