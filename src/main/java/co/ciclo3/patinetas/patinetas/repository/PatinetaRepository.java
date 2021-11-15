package co.ciclo3.patinetas.patinetas.repository;


import co.ciclo3.patinetas.patinetas.model.Patineta;

import co.ciclo3.patinetas.patinetas.repository.crud.PatinetaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatinetaRepository {
    @Autowired
    private PatinetaCrudRepository patinetaCrudRepository;
    
    public List<Patineta> getAll(){
        return (List<Patineta>) patinetaCrudRepository.findAll();
    }
    public Optional<Patineta> getPatineta(long id){
        return patinetaCrudRepository.findById(id);
    }
    public Patineta save(Patineta p) {
        return patinetaCrudRepository.save(p);
    }
    public void delete(Patineta p) {
        patinetaCrudRepository.delete(p);
    }
}
