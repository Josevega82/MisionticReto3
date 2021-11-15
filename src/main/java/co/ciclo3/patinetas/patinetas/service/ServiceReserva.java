package co.ciclo3.patinetas.patinetas.service;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Mensaje;
import co.ciclo3.patinetas.patinetas.model.Reserva;
import co.ciclo3.patinetas.patinetas.repository.CategoriaRepository;
import co.ciclo3.patinetas.patinetas.repository.MensajeRepository;
import co.ciclo3.patinetas.patinetas.repository.ReservaRepository;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceReserva {
    @Autowired
    private ReservaRepository ReservaRepository;
    
    public List<Reserva> getAll(){
        
        return ReservaRepository.getAll();
    }
    public Optional<Reserva> getReserva(long id){
        return ReservaRepository.getReserva(id);
    }
    
    public Reserva save(Reserva c) {
        if (c.getIdReservation()==null){
            return ReservaRepository.save(c);
        }else{
            Optional<Reserva> pAux = ReservaRepository.getReserva(c.getIdReservation());
            if(pAux.isEmpty()){
                return ReservaRepository.save(c);
            }else{
                return c;
            }
        }
        
    }
    public Reserva update(Reserva c){
        if(c.getIdReservation()!= null){
            Optional<Reserva> g = ReservaRepository.getReserva(c.getIdReservation());
            if (!g.isEmpty()) {
             if (c.getDevolutionDate() != null) {
                 g.get().setDevolutionDate(c.getDevolutionDate());
             }
             if (c.getStartDate() != null) {
                 g.get().setStartDate(c.getStartDate());
             }
             if (c.getClient() != null) {
                 g.get().setClient(c.getClient());
             }
             if (c.getSkate() != null) {
                 g.get().setSkate(c.getSkate());
             }
             return ReservaRepository.save(g.get());
            }
                    
        }
        return c;
    }
    public boolean deleteReserva(long id){
        Optional<Reserva> c = getReserva(id);
        if (!c.isEmpty()){
            ReservaRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
