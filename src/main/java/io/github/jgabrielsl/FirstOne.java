package io.github.jgabrielsl;

import io.github.jgabrielsl.domain.model.Client;
import io.github.jgabrielsl.domain.repository.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"io.github.jgabrielsl"})
public class FirstOne {

    @Bean
    public CommandLineRunner init(@Autowired Clients clients) {
        return args -> {
            clients.save(new Client("João Gabriel"));
            clients.save(new Client("Paula Cynthia"));

            System.out.println("Buscando todos os clients");
            List<Client> allClients = clients.findAll();
            allClients.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clients.findByNameLike("Gab").forEach(System.out::println);

            System.out.println("Atualizando clients");
            allClients.forEach(c -> {
                c.setName(c.getName() + " atualizado");
                clients.save(c);
            });

            List<Client> cli1 = clients.getClientById(1);
            cli1.forEach(System.out::println);

            allClients = clients.findAll();
            allClients.forEach(System.out::println);

            System.out.println("Deletando os clients");
            allClients.forEach(c -> {
                clients.delete(c);
            });

            allClients = clients.findAll();
            if (allClients.isEmpty()) {
                System.out.println("Nenhum cliente encontrado.");
            } else {
                allClients.forEach(System.out::println);
            }


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstOne.class, args);
    }
}
