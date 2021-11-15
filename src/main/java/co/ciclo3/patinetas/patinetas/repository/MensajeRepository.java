package co.ciclo3.patinetas.patinetas.repository;


import co.ciclo3.patinetas.patinetas.model.Mensaje;
import co.ciclo3.patinetas.patinetas.model.Patineta;
import co.ciclo3.patinetas.patinetas.repository.crud.MensajeCrudRepository;

import co.ciclo3.patinetas.patinetas.repository.crud.PatinetaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MensajeRepository {
    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;
    
    public List<Mensaje> getAll(){
        return (List<Mensaje>) mensajeCrudRepository.findAll();
    }
    public Optional<Mensaje> getMensaje(long id){
        return mensajeCrudRepository.findById(id);
    }
    public Mensaje save(Mensaje p) {
        return mensajeCrudRepository.save(p);
    }
    public void delete(Mensaje p) {
        mensajeCrudRepository.delete(p);
    }
}
