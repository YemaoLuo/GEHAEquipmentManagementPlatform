package org.geha.domain;
/*
  User: Yemao Luo
  Date: 2021/10/22
  Time: 19:21
*/

import java.util.Date;

public class BRSQL {

    private int uid;
    private int eid;
    private Date date;
    private Boolean returns;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getReturns() {
        return returns;
    }

    public void setReturns(Boolean returns) {
        this.returns = returns;
    }
}
