package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.services.AnuncioService;

import java.util.List;

@RestController
@RequestMapping ("apis/anuncio")
public class AnuncioRestController {
    @Autowired
    private AnuncioService anuncioService;

    @GetMapping
    public ResponseEntity<Object> getAll () {
        List<Anuncio> anuncios = anuncioService.getAll();
        if (anuncios != null && !anuncios.isEmpty())
            return ResponseEntity.ok(anuncios);
        return ResponseEntity.badRequest().body(new Erro("Anuncio não encontrado!"));
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Anuncio anuncio) {
        Anuncio anuncio2 = anuncioService.add(anuncio);
        if (anuncio2 != null)
            return ResponseEntity.ok(anuncio2);
        return ResponseEntity.badRequest().body(new Erro(("Erro ao adicionar o anúncio!")));
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody Anuncio anuncio) {
        Anuncio anuncio2 = anuncioService.add(anuncio);
        if (anuncio2 != null)
            return ResponseEntity.ok(anuncio2);
        return ResponseEntity.badRequest().body(new Erro(("Erro ao alterar o anúncio!")));
    }
}
