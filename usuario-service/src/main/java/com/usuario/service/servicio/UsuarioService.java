package com.usuario.service.servicio;

// Importaciones necesarias
import com.usuario.service.entidades.Usuario;
import com.usuario.service.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase define el servicio para manejar la lógica de negocio relacionada con la entidad Usuario.
 * Utiliza un repositorio para interactuar con la base de datos.
 */
@Service // Anotación que indica que esta clase es un servicio de Spring
public class UsuarioService {

    @Autowired // Anotación que permite la inyección automática de dependencias
    private UsuarioRepository usuarioRepository; // Instancia del repositorio que maneja la persistencia de Usuario

    /**
     * Obtiene todos los usuarios de la base de datos.
     * @return una lista de todos los usuarios.
     */
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
