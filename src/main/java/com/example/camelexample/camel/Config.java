package com.example.camelexample.camel;

import com.progressoft.corpay.oab.vasco.administration.AdministrationPortType;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CxfEndpoint adminittration(@Qualifier("basicCxfEndpoint") CxfEndpoint basicCxfEndpoint) {
        return buildCxfEndpoint(basicCxfEndpoint, AdministrationPortType.class);
    }

    @Bean
    public CxfEndpoint basicCxfEndpoint(@Value("${oab.url}") String oabWebserviceUrl) {
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress(oabWebserviceUrl);
        cxfEndpoint.setDataFormat(DataFormat.POJO);
        return cxfEndpoint;
    }

    private CxfEndpoint buildCxfEndpoint(CxfEndpoint basicCxfEndpoint, Class<?> serviceClass) {
        CxfEndpoint cxfEndpoint = basicCxfEndpoint.copy();
        cxfEndpoint.setAddress(basicCxfEndpoint.getAddress());
        cxfEndpoint.setServiceClass(serviceClass);
        return cxfEndpoint;
    }
}
