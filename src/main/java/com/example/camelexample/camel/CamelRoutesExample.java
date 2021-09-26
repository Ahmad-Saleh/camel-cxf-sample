package com.example.camelexample.camel;

import com.progressoft.corpay.oab.vasco.administration.AdminDomainList;
import com.progressoft.corpay.oab.vasco.administration.UserAttributeSet;
import com.progressoft.corpay.oab.vasco.administration.UserCmdIDEnum;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CamelRoutesExample extends RouteBuilder {

    @Override
    public void configure() {

        from("timer:test?delay=2s")
                .log("the file ${header.CamelFileName} has been read")
                .log("content:  ${body}")
                .process(exchange -> {
                    Map<String, Object> map = new HashMap<>();
                    List list = new ArrayList();
                    list.add("test");
                    list.add(UserCmdIDEnum.USERCMD_CREATE);
                    list.add(new UserAttributeSet());
                    list.add(new AdminDomainList());
                    exchange.getMessage().setBody(list);
                })
                .to("cxf:bean:adminittration?defaultOperationName=userExecute")
                .log("response: ${body}");

    }
}
