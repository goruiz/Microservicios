package com.usuario.service.repositorio;

// Importación de JpaRepository y Repository de Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.usuario.service.entidades.Usuario;

/**
 * Esta interfaz actúa como el repositorio para la entidad Usuario.
 * Extiende JpaRepository para proporcionar operaciones CRUD y otras operaciones de persistencia sobre la entidad Usuario.
 */
@Repository // Anotación que indica que esta interfaz es un repositorio Spring
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // No es necesario definir ningún método, JpaRepository proporciona métodos CRUD por defecto
}
