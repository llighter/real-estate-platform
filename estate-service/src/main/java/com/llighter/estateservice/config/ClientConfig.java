package com.llighter.estateservice.config;

import com.llighter.estateservice.FintechClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {
    @Bean
    FintechClient fintechClient() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8081/v1/real-estate-compare")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(FintechClient.class);
    }
}
