package com.example.camelexample.camel;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Data
@CsvRecord(separator = ",")
public class Person {

    @DataField(pos = 1)
    private String firstName;
    @DataField(pos = 2)
    private String lastName;
    @DataField(pos = 3)
    private int age;
}
