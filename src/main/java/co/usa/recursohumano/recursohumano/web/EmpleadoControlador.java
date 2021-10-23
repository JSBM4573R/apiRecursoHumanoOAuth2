package co.usa.recursohumano.recursohumano.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.recursohumano.recursohumano.model.Empleado;
import co.usa.recursohumano.recursohumano.service.EmpleadoServicio;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}) //CrossOrigin
public class EmpleadoControlador {
    
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/all")
    public List<Empleado>getEmpleados(){
        return empleadoServicio.getAll();
    }

    @GetMapping("/{id}")    //entre {} esta indicando que esta enviando una variable JSON
    public Optional<Empleado>getEmpleado(@PathVariable("id") int id){
        return empleadoServicio.getEmpleado(id);
    }

    @PostMapping("/save")   //Postmapping permite activar la funcion adentro inmediatamente de invoca
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoServicio.save(empleado);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado update(@RequestBody Empleado empleado){
        return empleadoServicio.update(empleado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteEmpleado(@PathVariable("id") int id){
        return empleadoServicio.deleteEmpleado(id);
    }
}
