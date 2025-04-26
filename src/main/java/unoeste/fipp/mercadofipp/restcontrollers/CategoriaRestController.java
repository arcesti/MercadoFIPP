package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.mercadofipp.entities.Categoria;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.services.CategoriaService;

import java.util.List;


@RestController
@RequestMapping("apis/categoria")
public class CategoriaRestController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Categoria> categorias = categoriaService.getAll();
        if (categorias!=null && !categorias.isEmpty()) {
            return ResponseEntity.ok(categorias);
        }
        return ResponseEntity.badRequest().body(new Erro("Categorias não encontradas!"));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name = "id") Long id) {
        Categoria categoria = categoriaService.getById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        }
        return ResponseEntity.badRequest().body(new Erro("Categoria não encontrada!"));
    }

    @PostMapping
    public ResponseEntity<Object> addCategoria(@RequestBody Categoria categoria) {
        Categoria categ = categoriaService.save(categoria);
        if (categoria != null)
            return ResponseEntity.ok(categ);
        return ResponseEntity.badRequest().body(new Erro("Não foi possível cadastrar a nova categoria!"));
    }

    @PutMapping
    public ResponseEntity<Object> updCategoria(@RequestBody Categoria categoria) {
        Categoria categ = categoriaService.save(categoria);
        if (categ != null)
            return ResponseEntity.ok(categ);
        return ResponseEntity.badRequest().body(new Erro("Não foi possível altear a categoria!"));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCategoria(@PathVariable(name = "id") Long id) {
        boolean flag = categoriaService.delete(id);
        if (flag)
            return ResponseEntity.ok("Categoria excluida!");
        return ResponseEntity.badRequest().body(new Erro("Erro ao escluir categoria!"));
    }
}




