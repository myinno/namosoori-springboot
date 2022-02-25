package com.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ConfigurationProperties("truthman")
public class TruthmanProperties {

    private String name;

    private int howLong;
}