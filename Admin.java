/*
 author: Stavros Kontzias, Kyle Kim, Matt Bosek, Hunter Whitelock
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
