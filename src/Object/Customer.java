/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author Admin
 */
public class Customer implements Comparable<Customer>{

    private String idCus;
    private String nameCus;

    public Customer(String idCus, String nameCus) {
        this.idCus = idCus;
        this.nameCus = nameCus;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    @Override
    public int compareTo(Customer o) {
        return this.idCus.compareTo(o.idCus);
    }

    @Override
    public String toString() {
        return String.format("%-5s|%-20s\n", idCus, nameCus);
    }
}
