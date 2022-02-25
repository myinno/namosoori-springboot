package com.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StarterRunner implements ApplicationRunner {

    @Autowired
    Truthman truthman;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	System.out.println("StarterRunner ...");
        System.out.println(truthman);
    }
    
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("CommandLineRunner Args: ");
//        System.out.println("CommandLineRunner Args: " + Arrays.toString(args));
//    }    
}

