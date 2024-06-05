package com.moto.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entidades.Moto;
import com.moto.service.servicios.MotoService;

@RestController
@RequestMapping("/moto")
public class MotroController {
     // Inyección de dependencia de MotoService para utilizar sus métodos
    @Autowired
    private MotoService motoService;

    // Maneja las solicitudes GET a la ruta "/carro"
    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos() {
        // Obtiene todos las motos mediante el servicio
        List<Moto> motos = motoService.getAll();
        // Si no hay motos, devuelve una respuesta sin contenido (204 No Content)
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        // Si hay motos, devuelve la lista de motos con una respuesta OK (200 OK)
        return ResponseEntity.ok(motos);
    }

    // Maneja las solicitudes GET a la ruta "/moto/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id) {
        // Obtiene una moto específica por su ID mediante el servicio
        Moto moto = motoService.getMotoById(id);
        // Si el carro no existe, devuelve una respuesta de no encontrado (404 Not Found)
        if (moto == null) {
            return ResponseEntity.notFound().build();
        }
        // Si el carro existe, devuelve la moto con una respuesta OK (200 OK)
        return ResponseEntity.ok(moto);
    }

    // Maneja las solicitudes POST a la ruta "/carro"
    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto) {
        // Guarda el nuevo carro mediante el servicio
        Moto nuevaMoto = motoService.save(moto);
        // Devuelve el carro guardado con una respuesta OK (200 OK)
        return ResponseEntity.ok(nuevaMoto);
    }

    // Maneja las solicitudes GET a la ruta "/moto/usuario/{usuarioId}"
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id) {
        // Obtiene la lista de motos por el ID de usuario mediante el servicio
        List<Moto> motos = motoService.getMotoByUsuarioId(id);
        // Si no hay motos para ese usuario, devuelve una respuesta sin contenido (204 No Content)
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        // Si hay motos, devuelve la lista de motos con una respuesta OK (200 OK)
        return ResponseEntity.ok(motos);
    }


}
