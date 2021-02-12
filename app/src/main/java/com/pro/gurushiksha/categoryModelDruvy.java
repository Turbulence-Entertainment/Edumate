package com.pro.gurushiksha;

public class categoryModelDruvy {

    private String image_url_category;
    private String title_category;

    public categoryModelDruvy(String image_url_category, String title_category) {
        this.image_url_category = image_url_category;
        this.title_category = title_category;
    }

    public String getImage_url_category() {
        return image_url_category;
    }

    public void setImage_url_category(String image_url_category) {
        this.image_url_category = image_url_category;
    }

    public String getTitle_category() {
        return title_category;
    }

    public void setTitle_category(String title_category) {
        this.title_category = title_category;
    }
}
