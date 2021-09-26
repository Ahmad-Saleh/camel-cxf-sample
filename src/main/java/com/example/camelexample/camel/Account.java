package com.example.camelexample.camel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CsvRecord(separator = ",")
public class Account {

    @DataField(pos = 1)
    private String accNumber;
    @DataField(pos = 2)
    private String accDescription;
    @DataField(pos = 3)
    private boolean activeFlag;
    @DataField(pos = 4)
    private String tenantName;
}
