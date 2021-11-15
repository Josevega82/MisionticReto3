package co.ciclo3.patinetas.patinetas.repository;


import co.ciclo3.patinetas.patinetas.model.Cliente;
import co.ciclo3.patinetas.patinetas.model.Patineta;
import co.ciclo3.patinetas.patinetas.repository.crud.ClienteCrudRepository;

import co.ciclo3.patinetas.patinetas.repository.crud.PatinetaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    
    public List<Cliente> getAll(){
        return (List<Cliente>) clienteCrudRepository.findAll();
    }
    public Optional<Cliente> getCliente(long id){
        return clienteCrudRepository.findById(id);
    }
    public Cliente save(Cliente p) {
        return clienteCrudRepository.save(p);
    }
    public void delete(Cliente p) {
        clienteCrudRepository.delete(p);
    }
}
