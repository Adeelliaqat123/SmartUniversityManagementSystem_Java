package Models;

public abstract class Person {
    private String name;
    private String id;
    private String email;
    private String phone;


    public Person(String name, String id, String email, String phone) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
    }//End Person Class

    public String getName() { 
        return name; 
    }

    public String getId() { 
        return id; 
    }

    protected String getEmail() { 
        return email; 
    }

    protected String getPhone() { 
        return phone; 
    }

    public abstract void register();
    public abstract void login();
    public abstract String[] getPermissions();

    public String getRole() { 
    return "Person"; 
}

}//End Abstract Class