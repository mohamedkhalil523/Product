package com.fst.gestion_produit.Controller;

import com.fst.gestion_produit.Entities.Produit;
import com.fst.gestion_produit.Repository.ProduitRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Poduitcontroller {
    @Autowired
    ProduitRepository produitRepository ;
    @GetMapping(path="/produit")
    public String list(Model model){
       List<Produit> produit =produitRepository.findAll();
       model.addAttribute("produit",produit);


        return "affichage";
    }
    @GetMapping(path = "/forma")
    public String ajout(Model model){
        model.addAttribute("produit", new Produit());

        return "/forma";
    }
    @PostMapping("/save")
    public String save(@Valid Produit produit , BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()){
            return "/forma";
        }
         produitRepository.save(produit);
        return "redirect:produit";

    }
    @GetMapping("/supprimer")
    public String supp(long id) {
        produitRepository.deleteById(id);
        return "redirect:produit";
    }
    @GetMapping ("/modifier")
    public String modifier(Model model ,long id)
    {
        Produit produit =produitRepository.findById(id).orElse(null);
        if(produit==null) throw new RuntimeException("Produit introuvable !!");
        model.addAttribute("produit",produit);
        return "formmod";
    }

    {

    }


}
