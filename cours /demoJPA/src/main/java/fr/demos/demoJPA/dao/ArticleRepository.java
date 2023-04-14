package fr.demos.demoJPA.dao;

import fr.demos.demoJPA.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByRef(String ref);

    Article findByDesignationContains(String texte);
}