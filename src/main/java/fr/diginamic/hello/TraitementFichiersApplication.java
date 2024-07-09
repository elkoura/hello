package fr.diginamic.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.hello.service.VilleService;

import org.springframework.boot.WebApplicationType;
@SpringBootApplication
public class TraitementFichiersApplication implements CommandLineRunner {

    @Autowired
    private VilleService villeService;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TraitementFichiersApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        villeService.importVillesFromCsv("C:\\Users\\fouad\\OneDrive\\Bureau\\recensement.csv");
    }
}
