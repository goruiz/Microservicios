package com.usuario.service.servicio;

// Importaciones necesarias
import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Esta clase define el servicio para manejar la lógica de negocio relacionada con la entidad Usuario.
 * Utiliza un repositorio para interactuar con la base de datos.
 */
@Service // Anotación que indica que esta clase es un servicio de Spring
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired // Anotación que permite la inyección automática de dependencias
    private UsuarioRepository usuarioRepository; // Instancia del repositorio que maneja la persistencia de Usuario

    public List<Carro> getCarros(int usuarioId){
        List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/"+usuarioId, List.class);
        return carros;
    }
    public List<Moto> getMotos(int usuarioId){
        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/"+usuarioId, List.class);
        return motos;
    }
    public List<Usuario> getAll(){
        return usuarioRepository.findAll(); // Llama al método findAll del repositorio para obtener todos los usuarios
    }

    /**
     * Obtiene un usuario por su ID.
     * @param id el ID del usuario que se quiere obtener.
     * @return el usuario correspondiente al ID proporcionado, o null si no se encuentra.
     */
    public Usuario getUsuarioById(int id){
        return  usuarioRepository.findById(id).orElse(null); // Llama al método findById del repositorio y devuelve el usuario si existe, de lo contrario devuelve null
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     * @param usuario el usuario que se quiere guardar.
     * @return el usuario guardado con su ID generado.
     */
    public Usuario save(Usuario usuario){
        Usuario nuevoUsuario = usuarioRepository.save(usuario); // Llama al método save del repositorio para guardar el usuario
        return nuevoUsuario; // Devuelve el usuario guardado
    }
}
