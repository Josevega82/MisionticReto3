package co.ciclo3.patinetas.patinetas.web;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Mensaje;
import co.ciclo3.patinetas.patinetas.service.ServiceCategoria;
import co.ciclo3.patinetas.patinetas.service.ServiceMensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MensajeController {
    
    @Autowired
    private ServiceMensaje ServiceMensaje;
    @GetMapping("/all")
    public List<Mensaje> getMensaje(){
        return ServiceMensaje.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Mensaje> getMensaje(@PathVariable("id") int id) {
        return ServiceMensaje.getMensaje(id);
    }
         
   
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje c) {
        return ServiceMensaje.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje c) {
        return ServiceMensaje.update(c);
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteMensaje(@PathVariable("id") long id) {
        return ServiceMensaje.deleteMensaje(id);
    }
}
