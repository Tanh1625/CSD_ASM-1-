/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author Admin
 */
public class Product implements Comparable<Product>{

    private String idProduct;
    private String nameProduct;
    private int quanlity;
    private double price;

    public Product(String idProduct, String nameProduct, int quanlity, double price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quanlity = quanlity;
        this.price = price;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public int compareTo(Product other) {
        return this.idProduct.compareTo(other.idProduct);
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-20s|%-15d|%-15.1f\n", idProduct, nameProduct, quanlity, price);
    }
}
