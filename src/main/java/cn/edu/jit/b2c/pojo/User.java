package cn.edu.jit.b2c.pojo;

public class User {
    private int user_id;

    private String name;

    private String password;

    private String email;

    private String img;

    private String address;

    private int role_id;

    private String phone;

    public User(int user_id, String name, String password, String email, String img, String address, int role_id, String phone) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.img = img;
        this.address = address;
        this.role_id = role_id;
        this.phone = phone;
    }

    public User() {
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


