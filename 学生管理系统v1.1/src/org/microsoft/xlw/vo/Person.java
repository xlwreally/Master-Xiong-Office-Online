package org.microsoft.xlw.vo;

import java.util.Date;

public class Person  {
    private String name;
    private String ID;
    private Date RegistTime;
    private String Birthday;
    private String Classname;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getRegistTime() {
        return RegistTime;
    }

    public void setRegidtTime(Date registTime) {
        RegistTime = registTime;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getClassname() {
        return Classname;
    }

    public void setClassname(String classname) {
        Classname = classname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", RegistTime=" + RegistTime +
                ", Birthday='" + Birthday + '\'' +
                ", Classname='" + Classname + '\'' +
                '}';
    }
}
