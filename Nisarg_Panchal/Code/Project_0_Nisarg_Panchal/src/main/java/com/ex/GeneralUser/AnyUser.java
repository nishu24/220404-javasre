package com.ex.GeneralUser;
// AnyUser can be a general user of the Banking System, Bank Employee or BankCustomer
public class AnyUser {

    private int id;
    private String username;
    private String password;

    /**
     *
     * @param username
     * @param password
     * @param id
     */
    public AnyUser(String username, String password, int id) { //parameterized Const.
        this.username=username;
        this.id=id;
        this.password=password;
    }
    public AnyUser() {
    }

    public AnyUser(String username, String password) {
        this.username=username;
        this.password=password;
    }

    //The default constructor is used to provide the default values to the object like 0, null, etc.
    //Getter & Setter:Imp in retrieving and updating the value of a variable outside the encapsulating class.
// A setter updates the value of a variable, while a getter reads the value of a variable.
    // Setting up Constructor and getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
