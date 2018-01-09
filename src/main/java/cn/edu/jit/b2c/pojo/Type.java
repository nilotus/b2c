package cn.edu.jit.b2c.pojo;

public class Type {
    private int type_id;

    private String name;

    private int pid;

    private int isp;

    public Type(){
    }

    public Type(int type_id, String name, int pid, int isp) {
        this.type_id = type_id;
        this.name = name;
        this.pid = pid;
        this.isp = isp;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getIsp() {
        return isp;
    }

    public void setIsp(int isp) {
        this.isp = isp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
