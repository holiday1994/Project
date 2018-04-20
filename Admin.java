/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author holly
 */
public class Admin extends User {

    private boolean manageEmployees = true;

    public Admin() {
        setEdit(true);
        setDelete(true);
        setAdd(true);
    }

    public void setManageEmployees(boolean manageEmployees) {
        this.manageEmployees = manageEmployees;
    }

    public boolean isManageEmployees() {
        return manageEmployees;
    }
}
