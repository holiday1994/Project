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
public class User {

    private boolean view = true;
    private boolean edit = false;
    private boolean add = false;
    private boolean delete = false;

    public void setView(boolean view) {
        this.view = view;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isView() {
        return view;
    }

    public boolean isEdit() {
        return edit;
    }

    public boolean isAdd() {
        return add;
    }

    public boolean isDelete() {
        return delete;
    }

    public User() {
        
    }
    
    }


