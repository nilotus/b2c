package cn.edu.jit.b2c.pojo;

public class Login {

    private int phone;

    private int role_id;

    private String userpassword;

    public int getRole_id(){
        return role_id;
    }

    public void setRole_id(int role_id){
        this.role_id = role_id;
    }

    public String getUserpassword(){
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}

