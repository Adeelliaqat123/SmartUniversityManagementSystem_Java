package Models;


public abstract class Person {
    private String id;
    private String name;
    private String email;
    private String phone;

    public Person(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    protected String getEmail() { return email; }
    protected String getPhone() { return phone; }

    public abstract void register();
    public abstract void login();
    public abstract String getRole();
}
