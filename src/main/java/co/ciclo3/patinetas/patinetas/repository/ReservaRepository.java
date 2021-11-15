package co.ciclo3.patinetas.patinetas.repository;


import co.ciclo3.patinetas.patinetas.model.Patineta;
import co.ciclo3.patinetas.patinetas.model.Reserva;

import co.ciclo3.patinetas.patinetas.repository.crud.PatinetaCrudRepository;
import co.ciclo3.patinetas.patinetas.repository.crud.ReservaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepository {
    @Autowired
    private ReservaCrudRepository reservaCrudRepository;
    
    public List<Reserva> getAll(){
        return (List<Reserva>) reservaCrudRepository.findAll();
    }
    public Optional<Reserva> getReserva(long id){
        return reservaCrudRepository.findById(id);
    }
    public Reserva save(Reserva p) {
        return reservaCrudRepository.save(p);
    }
    public void delete(Reserva p) {
        reservaCrudRepository.delete(p);
    }
}
