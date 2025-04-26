package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.entities.Usuario;
import unoeste.fipp.mercadofipp.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping(value = "apis/usuario")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Usuario> usuarios = usuarioService.getAll();
        if (usuarios!=null && !usuarios.isEmpty())
            return ResponseEntity.ok(usuarios);
        return ResponseEntity.badRequest().body(new Erro("Não foi possível recuperar usuários!"));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name = "id") Long id){
        Usuario usuario = usuarioService.getById(id);
        if (usuario != null)
            return ResponseEntity.ok(usuario);
        return ResponseEntity.badRequest().body(new Erro("Não foi possível encontrar o usuário!"));
    }

    @PostMapping
    public ResponseEntity<Object> inserir(Usuario usuario) {
        Usuario user = usuarioService.save(usuario);
        if(user != null)
            return ResponseEntity.ok(user);
        return ResponseEntity.badRequest().body(new Erro("Erro ao criar usuário!"));
    }

}
