/*
 author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
This file is the admin class hierarcy
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
