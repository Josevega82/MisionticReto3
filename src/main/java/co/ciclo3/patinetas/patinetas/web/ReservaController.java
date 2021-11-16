package co.ciclo3.patinetas.patinetas.web;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Reserva;
import co.ciclo3.patinetas.patinetas.service.ServiceCategoria;
import co.ciclo3.patinetas.patinetas.service.ServiceReserva;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservaController {
    
    @Autowired
    private ServiceReserva serviceReserva;
    
    @GetMapping("/all")
    public List<Reserva> getReserva(){
        return serviceReserva.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reserva> getReserva(@PathVariable("id") int id) {
        return serviceReserva.getReserva(id);
    }
         

    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva c) {
        
        if(c.getIdReservation()== null){
            c.setStatus("created");
            
             return serviceReserva.save(c);
            
                    
        }
        return c;
//        Optional<Reserva> pAux = serviceReserva.getReserva(c.getIdReservation());
//        pAux.get().setStatus("created");
//        return serviceReserva.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva c) {
        return serviceReserva.update(c);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deleteReserva(@PathVariable("id") long id) {
        return serviceReserva.deleteReserva(id);
    }
}
