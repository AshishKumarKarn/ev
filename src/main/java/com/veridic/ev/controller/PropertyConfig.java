package com.veridic.ev.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("greet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyConfig {
    private String message;
}
