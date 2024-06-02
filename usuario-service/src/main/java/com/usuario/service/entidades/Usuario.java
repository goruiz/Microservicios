package com.usuario.service.entidades;

// Importación de las anotaciones de Jakarta Persistence
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Esta clase representa una entidad de usuario en la base de datos.
 * Es utilizada por el framework JPA (Jakarta Persistence API) para mapear la clase Java a una tabla en la base de datos.
 * El autor de esta clase es Lenovo.
 */
@Entity // Anotación que indica que esta clase es una entidad JPA
public class Usuario {
    @Id // Indica que el campo 'id' es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de 'id' se genera automáticamente por la base de datos
    private int id; // Campo que almacena el ID del usuario

    private String nombre; // Campo que almacena el nombre del usuario
    private String email; // Campo que almacena el email del usuario

    // Método getter para el campo 'id'
    public int getId() {
        return id;
    }

    // Método setter para el campo 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Método getter para el campo 'nombre'
    public String getNombre() {
        return nombre;
    }

    // Método setter para el campo 'nombre'
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para el campo 'email'
    public String getEmail() {
        return email;
    }

    // Método setter para el campo 'email'
    public void setEmail(String email) {
        this.email = email;
    }
}
