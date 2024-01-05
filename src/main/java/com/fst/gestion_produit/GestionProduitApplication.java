package com.fst.gestion_produit;

import com.fst.gestion_produit.Entities.Produit;
import com.fst.gestion_produit.Repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionProduitApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProduitRepository produitRepository) {
        return args -> {
            produitRepository.save(new Produit(1,"PC",5000,"informatique"));

            produitRepository.findAll().forEach(produit -> {
              System.out.println(produit.getNom());

            });
        };

    }
}

