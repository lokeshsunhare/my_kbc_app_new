package com.example.kbc_new;

import java.io.Serializable;

public class Option implements Serializable {
    private int id;
    private String option;
    private boolean check;

    public Option(int id, String option, boolean check) {
        this.id = id;
        this.option = option;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
