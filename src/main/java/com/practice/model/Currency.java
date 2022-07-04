package com.practice.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "CharCode")
    private String charCode;
    @Column(name = "Name")
    private String name;
    @Column(name = "Nominal")
    private long nominal;
    @Column(name = "Value")
    private long value;
    @Column(name = "Date")
    private Date date;

    public Currency() {
    }

    public long getId() {
        return id;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNominal() {
        return nominal;
    }

    public void setNominal(long nominal) {
        this.nominal = nominal;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
