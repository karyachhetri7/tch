package com.example.tch.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class BankDetail implements Serializable {

    @Id
    @CsvBindByName(column = "ID")
    private Long id;

    @CsvBindByName(column = "Bank Name")
    private String bankName;

    @Enumerated(EnumType.STRING)
    @CsvBindByName(column = "Type")
    private Type type;

    @CsvBindByName(column = "City")
    private String city;

    @Enumerated(EnumType.STRING)
    @CsvBindByName(column = "State")
    private State state;

    @CsvBindByName(column = "Zip code")
    private int zipCode;
}
