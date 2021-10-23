package co.usa.recursohumano.recursohumano.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import co.usa.recursohumano.recursohumano.repository.crud.DepartamentoCrudRepositorio;
import co.usa.recursohumano.recursohumano.model.Departamento;

@Repository
public class DepartamentoRepositotio {

    @Autowired
    private DepartamentoCrudRepositorio departamentoCrudRepositorio;
    
    public List<Departamento>getAll(){
        return (List<Departamento>)departamentoCrudRepositorio.findAll();
    }

    public Optional<Departamento>getDepartamento(int id){
        return departamentoCrudRepositorio.findById(id);
    }

    public Departamento save(Departamento dpto){
        return departamentoCrudRepositorio.save(dpto);
    }

    public void delete(Departamento dpto){
        departamentoCrudRepositorio.delete(dpto);
    }
}
