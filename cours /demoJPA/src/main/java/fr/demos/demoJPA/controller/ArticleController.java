package fr.demos.demoJPA.controller;

import fr.demos.demoJPA.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import fr.demos.demoJPA.model.Article;

@CrossOrigin
@RestController
@RequestMapping(path = "/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository rep;

    @GetMapping()
    public List<Article> rechercheTous() {
        return rep.findAll();
    }

    //il faut que les getMapping soit différents pour qu'il recherche les params
    @GetMapping(params = {"ref"})
    public List<Article> rechercheParRef(@RequestParam String ref) {
        return rep.findByRef(ref);
    }

    @GetMapping(params = {"id"})
    public Optional<Article> rechercheParId(@RequestParam long id) {
        return rep.findById(id);
    }

   @GetMapping(params = {"designation"})
    public Article rechercheParDesignation(@RequestParam String designation) {
      return rep.findByDesignationContains(designation);
    }
}
