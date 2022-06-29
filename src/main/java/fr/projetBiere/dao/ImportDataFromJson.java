package fr.projetBiere.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.Biere;
import fr.projetBiere.entities.Carte;
import fr.projetBiere.entities.Categorie;
import fr.projetBiere.entities.Style;
import fr.projetBiere.entities.User;

public class ImportDataFromJson {

    public static void insertData(CategorieRepository categorieRepo, StyleRepository styleRepo, BiereRepository biereRepo,BarRepository barRepo, UserRepository userRepo, CarteRepository carteRepo) {
        ObjectMapper mapper = new ObjectMapper();


        // Enregistrement des catégories de bières
        TypeReference<List<Categorie>> typeReference = new TypeReference<List<Categorie>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/cat_beers_v1.json");
        try {
            List<Categorie> categories = mapper.readValue(inputStream, typeReference);
            for (Categorie cat:categories) {
                categorieRepo.save(cat);
            }
            System.out.println("catégories saved");
        } catch (IOException e) {
            System.out.println("Unable to save catégories: " + e.getMessage());
        }

        // Enregistrement des styles de bières
        TypeReference<List<Style>> typeReference2 = new TypeReference<List<Style>>() {
        };
        InputStream inputStream2 = TypeReference.class.getResourceAsStream("/style_beers_v2.json");

        try {
            List<Style> styles = mapper.readValue(inputStream2, typeReference2);
            for (Style style:styles) {
                styleRepo.save(style);
            }
            System.out.println("styles saved");
        } catch (IOException e) {
            System.out.println("Unable to save styles: " + e.getMessage());
        }

        // Enregistrement des différentes b
        TypeReference<List<Biere>> typeReference3 = new TypeReference<List<Biere>>() {
        };
        InputStream inputStream3 = TypeReference.class.getResourceAsStream("/beers_v1.json");

        try {
            List<Biere> bieres = mapper.readValue(inputStream3, typeReference3);
            for (Biere biere:bieres) {
                biereRepo.save(biere);
                }
                System.out.println("bières saved");
            } catch (IOException e) {
                System.out.println("Unable to save bières: " + e.getMessage());
            }
        TypeReference<List<Bar>> typeReference4 = new TypeReference<List<Bar>>() {
        };
        InputStream inputStream4 = TypeReference.class.getResourceAsStream("/bars.json");

        try {
            List<Bar> bars = mapper.readValue(inputStream4, typeReference4);
            for (Bar bar:bars) {
                barRepo.save(bar);
                }
                System.out.println("bars saved");
            } catch (IOException e) {
                System.out.println("Unable to save bars: " + e.getMessage());
            }
        
        TypeReference<List<User>> typeReference5 = new TypeReference<List<User>>() {
        };
        InputStream inputStream5 = TypeReference.class.getResourceAsStream("/users.json");

        try {
            List<User> users = mapper.readValue(inputStream5, typeReference5);
            for (User user:users) {
                userRepo.save(user);
                }
                System.out.println("users saved");
            } catch (IOException e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        
        TypeReference<List<Carte>> typeReference6 = new TypeReference<List<Carte>>() {
        };
        InputStream inputStream6 = TypeReference.class.getResourceAsStream("/Carte.json");

        try {
            List<Carte> cartes = mapper.readValue(inputStream6, typeReference6);
            for (Carte carte:cartes) {
                carteRepo.save(carte);
                }
                System.out.println("cartes saved");
            } catch (IOException e) {
                System.out.println("Unable to save cartes: " + e.getMessage());
            }
    }
}