package cn.edu.jit.b2c.pojo;

public class User {
    private int user_id;

    private String phone;

    private String password;

    private int role_id;

    private String name;

    private String img;

    private String address;

    private String email;

    public User(int user_id, String phone, String password, int role_id, String name, String img, String address, String email) {
        this.user_id = user_id;
        this.phone = phone;
        this.password = password;
        this.role_id = role_id;
        this.name = name;
        this.img = img;
        this.address = address;
        this.email = email;
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


