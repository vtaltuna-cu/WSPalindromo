/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda.model;

/**
 *
 * @author vivian
 */
public class Producto {
    
    private Integer id;
    private String brand;
    private String desription;
    private String image;
    private Integer price;
    private Boolean discount;
    private Integer percent;
    private Integer finalPrice;

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getDesription() {
        return desription;
    }

    public String getImage() {
        return image;
    }

    public Integer getPrice() {
        return price;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public Integer getPercent() {
        return percent;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public Producto(Integer id, String brand, String desription, String image, Integer price, Boolean discount, Integer percent) {
        this.id = id;
        this.brand = brand;
        this.desription = desription;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.percent = percent;
        this.finalPrice = discount?(int)Math.ceil((double)price*percent/100):price;
    }

    
}
