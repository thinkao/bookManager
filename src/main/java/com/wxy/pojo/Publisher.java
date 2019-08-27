package com.wxy.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String pub_id;
    @Column(length = 32)
    private String pub_name;
    @Column(length = 32)
    private String pub_addr;

    public Publisher() {
    }

    public Publisher(String pub_id, String pub_name, String pub_addr) {
        this.pub_id = pub_id;
        this.pub_name = pub_name;
        this.pub_addr = pub_addr;
    }

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }

    public String getPub_name() {
        return pub_name;
    }

    public void setPub_name(String pub_name) {
        this.pub_name = pub_name;
    }

    public String getPub_addr() {
        return pub_addr;
    }

    public void setPub_addr(String pub_addr) {
        this.pub_addr = pub_addr;
    }
}
