package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//CrossOrigin Elle permet de spécifier quelles origines sont autorisées à accéder aux ressources de votre API depuis des
// domaines différents   (*) signifie que toutes les origines sont autorisées à accéder à l'API.
@CrossOrigin(origins = "*",maxAge = 3600)
//RestController Elle indique que la classe Java est un contrôleur qui traitera les requêtes HTTP et renverra des réponses HTTP appropriées
@RestController
@RequestMapping("/api")
public class ProductController {
//@Autowired indique que vous souhaitez que Spring injecte automatiquement une instance de ProductService dans la variable productService. Cela signifie que vous n'avez pas besoin
// de créer manuellement une instance de ProductService ; Spring le fera pour vous et l'assignera à la variable productService.
// productService. Cette variable sera utilisée pour accéder aux méthodes et fonctionnalités fournies par le service ProductService.
    @Autowired
    ProductService productService;

    @GetMapping(value = "/products")
    public List<Produit> getAllProduits() {
        return productService.getAllProduits();
    }

    @PostMapping("/products")
    public Produit createProduit(@RequestBody Produit produit) {
        return productService.createProduit(produit);
    }

    @PutMapping("/products/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        produit.setId(id);
        Produit updatedProduit = productService.updateProduit(produit);
        if (updatedProduit == null) {
            throw new RessourceNotFoundException("Product with ID " + id + " not found.");
        }
        return updatedProduit;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduit(@PathVariable Long id) {
        productService.deleteProduit(id);
    }
    @GetMapping("/products/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return productService.getProduitById(id);
    }
}

