package fr.projetBiere.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.projetBiere.entities.Biere;
import fr.projetBiere.entities.Categorie;
import fr.projetBiere.entities.Style;

public class ImportDataFromJson {

    public static void insertData(CategorieRepository categorieRepo, StyleRepository styleRepo, BiereRepository biereRepo) {
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

        // Enregistrement des différentes bières
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
    }
}