package co.ciclo3.patinetas.patinetas.service;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Cliente;
import co.ciclo3.patinetas.patinetas.repository.CategoriaRepository;
import co.ciclo3.patinetas.patinetas.repository.ClienteRepository;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCliente {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Cliente> getAll(){
        
        return clienteRepository.getAll();
    }
    public Optional<Cliente> getCliente(long id){
        return clienteRepository.getCliente(id);
    }
    
    public Cliente save(Cliente c) {
        
        if (c.getIdClient()==null){
            return clienteRepository.save(c);
        }else{
            Optional<Cliente> pAux = clienteRepository.getCliente(c.getIdClient());
            if(pAux.isEmpty()){
                return clienteRepository.save(c);
            }else{
                return c;
            }
        }
        
    }
    public Cliente update(Cliente c){
        if(c.getIdClient() != null){
            Optional<Cliente> g = clienteRepository.getCliente(c.getIdClient());
            if (!g.isEmpty()) {
             if (c.getEmail() != null) {
                 g.get().setEmail(c.getEmail());
             }
             if (c.getAge()!= null) {
                 g.get().setAge(c.getAge());
             }
             if (c.getMessage()!= null) {
                 g.get().setMessage(c.getMessage());
             }
             if (c.getPassword()!= null) {
                 g.get().setPassword(c.getPassword());
             }
             if (c.getEmail() != null) {
                 g.get().setReservations(c.getReservations());
             }
             
             
             return clienteRepository.save(g.get());
            }
                    
        }
        return c;
    }
    public boolean deleteCliente(long id){
        Optional<Cliente> c = getCliente(id);
        if (!c.isEmpty()){
            clienteRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
