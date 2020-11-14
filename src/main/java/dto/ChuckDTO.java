/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fh
 */
public class ChuckDTO {
    private String id;
    private List<String> categories;
    private String created_at;
    private String icon_url;
    private String url;
    private String updated_at;
    private String value;

    public ChuckDTO(String id, List<String> categories, String created_at, String icon_url, String url, String updated_at, String value) {
        this.id = id;
        this.categories = new ArrayList<>();
        for (String s : categories) {
            this.categories.add(s);
        }
        this.created_at = created_at;
        this.icon_url = icon_url;
        this.url = url;
        this.updated_at = updated_at;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }



    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    

}
