package com.Azienda.viaggiAziendali.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ServerConfig {

    @Bean
    public Cloudinary configurazioneCloud(){
        Map<String,String> configurazione = new HashMap<String,String>();
        configurazione.put("cloud_name", "dhzqy2iyv");
        configurazione.put("api_key", "175265971227457");
        configurazione.put("api_secret", "Lrz2Qhmfn4rodgaP7EgtnHPUezk");
        return new Cloudinary(configurazione);
    }
}
