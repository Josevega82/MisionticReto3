package co.ciclo3.patinetas.patinetas.web;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Patineta;

import co.ciclo3.patinetas.patinetas.service.ServicePatineta;
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
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PatinetaController {
    @Autowired
    private ServicePatineta servicePatineta;
    @GetMapping("/all")
    public List<Patineta> getPatinetas() {
        return servicePatineta.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Patineta> getPatinetas(@PathVariable("id") int id) {
        return servicePatineta.getPatineta(id);
    }
    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Patineta saveAll(@RequestBody Patineta p) {
        return servicePatineta.save(p);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Patineta save(@RequestBody Patineta p) {
        return servicePatineta.save(p);
    }
    @PutMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Patineta update(@RequestBody Patineta p) {
        return servicePatineta.update(p);
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteCategoria(@PathVariable("id") long id) {
        return servicePatineta.deleteCategoria(id);
    }
   
}
