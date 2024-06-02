package com.carro.service.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.service.entidades.Carro;
import com.carro.service.repositorio.CarroRepository;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAll() {
        return carroRepository.findAll(); // Llama al método findAll del repositorio para obtener todos los Carros
    }

    /**
     * Obtiene un Carro por su ID.
     * 
     * @param id el ID del Carro que se quiere obtener.
     * @return el Carro correspondiente al ID proporcionado, o null si no se
     *         encuentra.
     */
    public Carro getCarroById(int id) {
        return carroRepository.findById(id).orElse(null); // Llama al método findById del repositorio y devuelve el
                                                          // Carro si existe, de lo contrario devuelve null
    }

    /**
     * Guarda un nuevo Carro en la base de datos.
     * 
     * @param carro el carro que se quiere guardar.
     * @return el carro guardado con su ID generado.
     */
    public Carro save(Carro carro) {
        Carro nuevoCarro = carroRepository.save(carro); // Llama al método save del repositorio para guardar el carro
        return nuevoCarro; // Devuelve el carro guardado
    }

    public List<Carro> byUsuarioId(int usuarioId) {
        return carroRepository.findByUsuarioId(usuarioId);
    }
}
