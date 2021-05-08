package ar.com.learning.University.service;

import ar.com.learning.University.Entity.Category;
import ar.com.learning.University.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repoCategory;

    public void createCategory(Category category) {
        repoCategory.save(category);
    }

    public Category createCategory(String name, String descripcion) {
        Category category = new Category();
        category.setName(name);
        category.setDescripcion(descripcion);
        repoCategory.save(category);
        return category;
    }

    public Category actualizarCategoria(Category category) {
        return repoCategory.save(category);
    }

    public Category buscarPorId(Long id) {
        Optional<Category> opCategory = repoCategory.findById(id);

        // Si tiene un valor de categoria en el elemento que trajo.
        // Camion con heladera dentro. hasta que no abrimos la puerta no sabemos si la
        // trajo.
        if (opCategory.isPresent())
            return opCategory.get();
        else
            return null;

    }

    public List<Category> buscarPorIds(List<Long> ids) {
        List<Category> listaCategory = repoCategory.findAllById(ids);

        // Si tiene un valor de categoria en el elemento que trajo.
        // Camion con heladera dentro. hasta que no abrimos la puerta no sabemos si la
        // trajo.
        if (!listaCategory.isEmpty())
            return listaCategory;
        else
            return null;

    }

    public List<Category> listarTodas() {
        return repoCategory.findAll();
    }
}
