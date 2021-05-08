package ar.com.learning.University.controller;

import ar.com.learning.University.Entity.Category;
import ar.com.learning.University.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CategoryController {
    // Declarar un service

    @Autowired
    CategoryService categoryService;

    // Post: que recibimos algo, que nos permite instanciar una Categoria y ponerle
    // datos.
    @PostMapping("/api/category")
    public ResponseEntity<GenericResponse> createCategory(@RequestBody Category category) {

        CategoryService.createCategory (category);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Categoria Creada con exito";
        r.id = categoria.getCategoriaId();

        // Aca vamos a usar Ok
        // Cuando se crea, generalmetnte para los puristas, se usa el
        // CreatedAtAction(201)
        return ResponseEntity.ok(r);

    }

    @PutMapping(("/category/{id}"))
    ResponseEntity<GenericResponse> actualizarCategoriaPorId(@PathVariable Integer id,
                                                             @RequestBody CategoriaModifRequest cMR) {
        Category category = categoryService.buscarPorId(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        Category categoriaActualizada = categoryService.actualizarCategoria(category);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Categoria actualizada con éxito";
        r.id = categoriaActualizada.getCategoriaId();

        return ResponseEntity.ok(r);
    }

    @GetMapping("/category/{id}")
    ResponseEntity<CategoryResponse> buscarPorIdCategoria(@PathVariable Long id) {
        Category category = categoryService.buscarPorId(id);

        CategoryResponse cGR = new CategoryResponse();
        cGR.name = category.getName();
        cGR.description = category.getDescription();

        return ResponseEntity.ok(cGR);
    }

    @GetMapping("/category")
    ResponseEntity<List<CategoryResponse>> listarCategorias() {
        List<Category> listaCategorias = categoryService.listarTodas();
        List<CategoryResponse> listaCategoriasResponse = new ArrayList<CategoryResponse>();
        for (Category c : listaCategorias) {
            CategoriaResponse cR = new CategoriaResponse();
            cR.name = c.getName();
            cR.description = c.getDescription();
            listaCategoriasResponse.add(cR);
        }
        return ResponseEntity.ok(listaCategoriasResponse);

}
