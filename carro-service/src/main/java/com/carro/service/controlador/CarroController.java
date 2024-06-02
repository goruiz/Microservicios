// Paquete donde se encuentra la clase controladora
package com.carro.service.controlador;

// Importaciones necesarias para el funcionamiento de la clase controladora
import com.carro.service.entidades.Carro; // Clase entidad Carro
import com.carro.service.servicios.CarroService; // Servicio de Carro
import org.springframework.beans.factory.annotation.Autowired; // Para la inyección de dependencias
import org.springframework.http.ResponseEntity; // Para manejar las respuestas HTTP
import org.springframework.web.bind.annotation.*; // Para las anotaciones de controladores y mapeo de rutas

import java.util.List; // Para trabajar con listas
import org.springframework.web.bind.annotation.GetMapping; // Anotación específica para mapeo GET
import org.springframework.web.bind.annotation.RequestParam; // Anotación para parámetros de solicitud

// Indica que esta clase es un controlador REST
@RestController
// Mapea las solicitudes HTTP a partir de la ruta "/carro"
@RequestMapping("/carro")
public class CarroController {

    // Inyección de dependencia de CarroService para utilizar sus métodos
    @Autowired
    private CarroService carroService;

    // Maneja las solicitudes GET a la ruta "/carro"
    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        // Obtiene todos los carros mediante el servicio
        List<Carro> carros = carroService.getAll();
        // Si no hay carros, devuelve una respuesta sin contenido (204 No Content)
        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        // Si hay carros, devuelve la lista de carros con una respuesta OK (200 OK)
        return ResponseEntity.ok(carros);
    }

    // Maneja las solicitudes GET a la ruta "/carro/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id) {
        // Obtiene un carro específico por su ID mediante el servicio
        Carro carro = carroService.getCarroById(id);
        // Si el carro no existe, devuelve una respuesta de no encontrado (404 Not Found)
        if (carro == null) {
            return ResponseEntity.notFound().build();
        }
        // Si el carro existe, devuelve el carro con una respuesta OK (200 OK)
        return ResponseEntity.ok(carro);
    }

    // Maneja las solicitudes POST a la ruta "/carro"
    @PostMapping
    public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro) {
        // Guarda el nuevo carro mediante el servicio
        Carro nuevoCarro = carroService.save(carro);
        // Devuelve el carro guardado con una respuesta OK (200 OK)
        return ResponseEntity.ok(nuevoCarro);
    }

    // Maneja las solicitudes GET a la ruta "/carro/usuario/{usuarioId}"
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int id) {
        // Obtiene la lista de carros por el ID de usuario mediante el servicio
        List<Carro> carros = carroService.byUsuarioId(id);
        // Si no hay carros para ese usuario, devuelve una respuesta sin contenido (204 No Content)
        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        // Si hay carros, devuelve la lista de carros con una respuesta OK (200 OK)
        return ResponseEntity.ok(carros);
    }

}
