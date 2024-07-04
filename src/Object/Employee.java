/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author Admin
 */
public class Employee implements Comparable<Employee>{

    private String idEmp;
    private String nameEmp;

    public Employee(String idEmp, String nameEmp) {
        this.idEmp = idEmp;
        this.nameEmp = nameEmp;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getNameEmp() {
        return nameEmp;
    }

    public void setNameEmp(String nameEmp) {
        this.nameEmp = nameEmp;
    }

    @Override
    public int compareTo(Employee o) {
        return this.idEmp.compareTo(o.idEmp);
    }

    @Override
    public String toString() {
        return String.format("%-5s|%-20s\n", idEmp, nameEmp);
    }
}
