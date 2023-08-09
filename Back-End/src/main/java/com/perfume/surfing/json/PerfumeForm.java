package com.perfume.surfing.json;

import java.util.List;

public class PerfumeForm {

    private String brand;
    private String brand_url;
    private String name;
    private String perfume_url;
    private String image;
    private String price;
    private List<String> top_nt;
    private List<String> mid_nt;
    private List<String> base_nt;
    private List<String> single_nt;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand_url() {
        return brand_url;
    }

    public void setBrand_url(String brand_url) {
        this.brand_url = brand_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerfume_url() {
        return perfume_url;
    }

    public void setPerfume_url(String perfume_url) {
        this.perfume_url = perfume_url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getTop_nt() {
        return top_nt;
    }

    public void setTop_nt(List<String> top_nt) {
        this.top_nt = top_nt;
    }

    public List<String> getMid_nt() {
        return mid_nt;
    }

    public void setMid_nt(List<String> mid_nt) {
        this.mid_nt = mid_nt;
    }

    public List<String> getBase_nt() {
        return base_nt;
    }

    public void setBase_nt(List<String> base_nt) {
        this.base_nt = base_nt;
    }

    public List<String> getSingle_nt() {
        return single_nt;
    }

    public void setSingle_nt(List<String> single_nt) {
        this.single_nt = single_nt;
    }
}
