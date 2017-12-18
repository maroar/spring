package desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "entidades" })
@EnableJpaRepositories(basePackages = {"repositorios"})
@ComponentScan(basePackages = {"controladores"})
public class Aplicacao {

    public static void main(String[] args) {

        SpringApplication.run(Aplicacao.class, args);
    }
    
}

