package cn.edu.jit.b2c.pojo;

import java.util.Arrays;
import java.util.List;

public class PushOrder {
    private Integer user_id;
    private List<Integer> good_id;
    private List<Integer> good_num;

    public PushOrder() {
    }

    public PushOrder(Integer user_id, List<Integer> good_id, List<Integer> good_num) {
        this.user_id = user_id;
        this.good_id = good_id;
        this.good_num = good_num;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<Integer> getGood_id() {
        return good_id;
    }

    public void setGood_id(List<Integer> good_id) {
        this.good_id = good_id;
    }

    public List<Integer> getGood_num() {
        return good_num;
    }

    public void setGood_num(List<Integer> good_num) {
        this.good_num = good_num;
    }

    @Override
    public String toString() {
        return "PushOrder{" +
                "user_id=" + user_id +
                ", good_id=" + good_id +
                ", good_num=" + good_num +
                '}';
    }
}
