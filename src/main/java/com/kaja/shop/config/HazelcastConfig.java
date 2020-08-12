package com.kaja.shop.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    Config configHazelcast() {
        return new Config().setInstanceName("shop")
                .addMapConfig(new MapConfig()
                        .setName("product")
                        .setEvictionConfig(new EvictionConfig()
                                .setSize(10000)
                                .setEvictionPolicy(EvictionPolicy.LFU))
                        .setTimeToLiveSeconds(60 * 60 * 24));


    }
}