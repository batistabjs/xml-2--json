package com.github.integrador.conversor;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "client-service", url = "${client.url}")
public interface ConversorClient {

    @Headers({"SOAPAction: searchAction", "Content-Type: text/xml;charset=UTF-8", "Accept: text/xml"})
    @PostMapping("/ServiceName")
    String searchXML (@RequestBody String payloadRequest);
}
