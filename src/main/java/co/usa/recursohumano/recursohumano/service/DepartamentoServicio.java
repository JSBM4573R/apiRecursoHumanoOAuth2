package co.usa.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumano.recursohumano.model.Departamento;
import co.usa.recursohumano.recursohumano.repository.DepartamentoRepositotio;

@Service
public class DepartamentoServicio {
    @Autowired
    DepartamentoRepositotio departamentoRepositorio;

    public List<Departamento> getAll(){
        return departamentoRepositorio.getAll();
        
    }

    public Optional<Departamento>getDepartamento(int id){
        return departamentoRepositorio.getDepartamento(id);
    }

    public Departamento save(Departamento dpto){
        //Verificar si el id es nulo
        if (dpto.getNumID()==null) {
            return departamentoRepositorio.save(dpto);
            
        }else{ //verifico si existe el id o no en la base de datos
            Optional<Departamento> consulta=departamentoRepositorio.getDepartamento(dpto.getNumID());

            if(consulta.isEmpty()){
                return departamentoRepositorio.save(dpto);
            }else{
                return dpto;
            }
        }
    }

    public Departamento update(Departamento dpto){
        if (dpto.getNumID()!=null){
            Optional<Departamento> consulta=departamentoRepositorio.getDepartamento(dpto.getNumID());
            if(!consulta.isEmpty()){
                //.get() me trae todo el objeto que contiene todos los atributos entonces
                //para actualizar utilizo setAtributo(y aqui ponemos el objeto el cual contiene
                //el dato ingresado para luego pasarle el nuevo dato con .getAtributo())
                if (dpto.getNombreDepartamento()!=null){
                    consulta.get().setNombreDepartamento(dpto.getNombreDepartamento());
                }
                if (dpto.getFechaCreacionDate()!=null){
                    consulta.get().setFechaCreacionDate(dpto.getFechaCreacionDate());
                }
                return departamentoRepositorio.save(consulta.get());
            }
        }
        return dpto;
    }

    public boolean deleteDepartamento(int id){
        Optional<Departamento> consulta=departamentoRepositorio.getDepartamento(id);
        if (!consulta.isEmpty()) {
            departamentoRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }

}
