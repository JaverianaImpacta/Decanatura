package edu.javeriana.ingenieria.social.decanatura.repositorio;

import edu.javeriana.ingenieria.social.decanatura.dominio.Decanatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDecanatura extends JpaRepository<Decanatura, Integer> {
    Decanatura findOneById(Integer id);

    List<Decanatura> findAllByFacultad(Integer facultad);
}
