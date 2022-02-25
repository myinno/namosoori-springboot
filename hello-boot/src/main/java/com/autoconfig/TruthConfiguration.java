package com.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TruthmanProperties.class)
public class TruthConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Truthman truthman(TruthmanProperties truthmanProperties) {
    	System.out.println("TruthConfiguration....");
        Truthman truthman = new Truthman();
        truthman.setName(truthmanProperties.getName());
        truthman.setHowLong(truthmanProperties.getHowLong());
        System.out.println(truthman.getName() + ":" + truthman.getHowLong());
        return truthman;
    }

}


// :\Users\김유성\.m2\repository\org\projectlombok\lombok\1.18.22>java -jar lombok-1.18.22.jar
//lombok오류 발생하면