package br.com.fiap.makeanote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class MakeanoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakeanoteApplication.class, args);
    }

//    @Bean
//    public CharacterEncodingFilter getCharacterEncodingFilter() {
//
//        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//
//        encodingFilter.setEncoding("UTF-8");
//        encodingFilter.setForceEncoding(true);
//
//        return encodingFilter;
//
//    }
}
