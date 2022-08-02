package com.github.integrador.conversor;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ConversorConfiguration {

    @Value("${client.url}")
    String url;

    @Value("${client.password}")
    String password;
}
