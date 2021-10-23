package co.usa.recursohumano.recursohumano.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.recursohumano.recursohumano.model.Departamento;
import co.usa.recursohumano.recursohumano.service.DepartamentoServicio;

@RestController
@RequestMapping("/api/Departamento") //Mapping crea una ruta
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}) //CrossOrigin
public class DepartamentoControlador {
    @Autowired
    private DepartamentoServicio departamentoServicio;

    @GetMapping("/all")
    public List<Departamento>getDepartamentos(){
        return departamentoServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Departamento>getDepartamento(@PathVariable("id") int id){ //@PathVariable toma lo que viene despues del //{id}
        return departamentoServicio.getDepartamento(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento save(@RequestBody Departamento dpto){ //@RequestBody recuperar el cuerpo
        return departamentoServicio.save(dpto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento update(@RequestBody Departamento dpto){
        return departamentoServicio.update(dpto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteDepartamento(@PathVariable("id") int id){
        return departamentoServicio.deleteDepartamento(id);
    }
}
