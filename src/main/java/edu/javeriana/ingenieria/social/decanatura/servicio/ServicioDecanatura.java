package edu.javeriana.ingenieria.social.decanatura.servicio;

import edu.javeriana.ingenieria.social.decanatura.dominio.Decanatura;
import edu.javeriana.ingenieria.social.decanatura.repositorio.RepositorioDecanatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDecanatura {

    @Autowired
    private RepositorioDecanatura repositorio;

    public List<Decanatura> obtenerDecanaturas() {
        return repositorio.findAll();
    }

    public List<Decanatura> obtenerDecanaturas(Integer facultad){
        return repositorio.findAllByFacultad(facultad);
    }

    public boolean decanaturaExiste(Integer id) {
        return repositorio.existsById(id);
    }

    public Decanatura obtenerDecanatura(Integer id) {
        return repositorio.findOneById(id);
    }
}