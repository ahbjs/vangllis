package com.bcal.www.vangills;

public class RecyclerData {

    private String title;
    private int imgid;
    private String productName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public RecyclerData(String title, int imgid,String productName) {
        this.title = title;
        this.imgid = imgid;
        this.productName = productName;
    }
}
