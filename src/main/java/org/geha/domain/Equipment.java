package org.geha.domain;
/*
  User: Yemao Luo
  Date: 2021/10/17
  Time: 9:44
*/

public class Equipment {
    private String inUse_str;

    public String getInUse_str() {
        return inUse_str;
    }

    private int id;
    private String name;
    private Boolean inUse;

    public void setInUse_str(String inUse_str) {
        this.inUse_str = inUse_str;
    }

    public Equipment(int id, String name, Boolean inUse) {
        this.id = id;
        this.name = name;
        this.inUse = inUse;
    }

    public Equipment() {
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inUse=" + inUse +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }
}
