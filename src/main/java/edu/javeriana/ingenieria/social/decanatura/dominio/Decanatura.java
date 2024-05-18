package edu.javeriana.ingenieria.social.decanatura.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Decanatura {
    @Id
    private Integer id;
    private Integer facultad, decano;
}
