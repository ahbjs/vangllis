package com.bcal.www.vangills;

public class RecyclerData {

    private int imgid;
    private String productName;
    private String imgUrl;
    private String price;
    private int itemID;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public RecyclerData(int imgid,String productName,String imageUrl,String price,int itemID) {
        this.imgid = imgid;
        this.productName = productName;
        this.imgUrl = imageUrl;
        this.price = price;
        this.itemID = itemID;
    }
}
