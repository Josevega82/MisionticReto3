package co.ciclo3.patinetas.patinetas.service;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Mensaje;
import co.ciclo3.patinetas.patinetas.repository.CategoriaRepository;
import co.ciclo3.patinetas.patinetas.repository.MensajeRepository;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMensaje {
    @Autowired
    private MensajeRepository mensajeRepository;
    
    public List<Mensaje> getAll(){
        
        return mensajeRepository.getAll();
    }
    public Optional<Mensaje> getMensaje(long id){
        return mensajeRepository.getMensaje(id);
    }
    
    public Mensaje save(Mensaje c) {
        if (c.getIdMessage()==null){
            return mensajeRepository.save(c);
        }else{
            Optional<Mensaje> pAux = mensajeRepository.getMensaje(c.getIdMessage());
            if(pAux.isEmpty()){
                return mensajeRepository.save(c);
            }else{
                return c;
            }
        }
        
    }
    public Mensaje update(Mensaje c){
        if(c.getIdMessage() != null){
            Optional<Mensaje> g = mensajeRepository.getMensaje(c.getIdMessage());
            if (!g.isEmpty()) {
             if (c.getMessageText() != null) {
                 g.get().setMessageText(c.getMessageText());
             }
             if (c.getClient() != null) {
                 g.get().setClient(c.getClient());
             }
             if (c.getSkate() != null) {
                 g.get().setSkate(c.getSkate());
             }
             return mensajeRepository.save(g.get());
            }
                    
        }
        return c;
    }
    public boolean deleteMensaje(long id){
        Optional<Mensaje> c = getMensaje(id);
        if (!c.isEmpty()){
            mensajeRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
