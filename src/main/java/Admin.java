public class Admin {
    private int id;
    private String name;
    private String username;
    private String password;

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
