package edu.javeriana.ingenieria.social.decanatura.controlador;

import edu.javeriana.ingenieria.social.decanatura.dominio.Decanatura;
import edu.javeriana.ingenieria.social.decanatura.servicio.ServicioDecanatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decanaturas")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorDecanatura {

    @Autowired
    private ServicioDecanatura servicio;

    @GetMapping("listar")
    public List<Decanatura> obtenerDecanaturas() {
        return servicio.obtenerDecanaturas();
    }

    @GetMapping("obtener")
    public ResponseEntity<Decanatura> obtenerDecanatura(@RequestParam Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.decanaturaExiste(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerDecanatura(id), HttpStatus.OK);
    }

    @GetMapping("obtenerFacultad")
    public ResponseEntity<List<Decanatura>> obtenerDecanaturas(@RequestParam Integer facultad){
        if(facultad == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerDecanaturas(facultad).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerDecanaturas(facultad), HttpStatus.OK);
    }
}
