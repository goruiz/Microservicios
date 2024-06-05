// Paquete donde se encuentra la clase controladora
package com.usuario.service.controlador;

// Importaciones necesarias para el funcionamiento de la clase controladora
import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Indica que esta clase es un controlador REST
@RestController
// Mapea las solicitudes HTTP a partir de la ruta "/usuario"
@RequestMapping("/usuario")
public class UsuarioController {

    // Inyección de dependencia de UsuarioService
    @Autowired
    private UsuarioService usuarioService;

    // Maneja las solicitudes GET a la ruta "/usuario"
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        // Obtiene todos los usuarios mediante el servicio
        List<Usuario> usuarios = usuarioService.getAll();
        // Si no hay usuarios, devuelve una respuesta sin contenido
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        // Si hay usuarios, devuelve la lista de usuarios con una respuesta OK
        return ResponseEntity.ok(usuarios);
    }

    // Maneja las solicitudes GET a la ruta "/usuario/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id) {
        // Obtiene un usuario específico por su ID mediante el servicio
        Usuario usuario = usuarioService.getUsuarioById(id);
        // Si el usuario no existe, devuelve una respuesta de no encontrado
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        // Si el usuario existe, devuelve el usuario con una respuesta OK
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarros(@PathVariable("usuarioId") int id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        List<Carro> carros = usuarioService.getCarros(id);
        return ResponseEntity.ok(carros);
    }


    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        List<Moto> motos = usuarioService.getMotos(id);
        return ResponseEntity.ok(motos);
    }

}
