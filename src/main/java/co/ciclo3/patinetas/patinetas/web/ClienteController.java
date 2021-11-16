package co.ciclo3.patinetas.patinetas.web;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Cliente;
import co.ciclo3.patinetas.patinetas.service.ServiceCategoria;
import co.ciclo3.patinetas.patinetas.service.ServiceCliente;
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
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClienteController {
    
    @Autowired
    private ServiceCliente ServiceCliente;
    
    @GetMapping("/all")
    public List<Cliente> getCliente(){
        return ServiceCliente.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") int id) {
        return ServiceCliente.getCliente(id);
    }
         
 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente c) {
        return ServiceCliente.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente c) {
        return ServiceCliente.update(c);
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteCliente(@PathVariable("id") long id) {
        return ServiceCliente.deleteCliente(id);
    }
}
