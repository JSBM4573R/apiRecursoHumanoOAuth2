package co.usa.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumano.recursohumano.model.Empleado;
import co.usa.recursohumano.recursohumano.repository.EmpleadoRepositorio;

@Service
public class EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado>getAll(){
        return empleadoRepositorio.getAll();
    }
    
    public Optional<Empleado>getEmpleado(int id){
        return empleadoRepositorio.getEmpleado(id);
    }

    public Empleado save(Empleado empleado){
        if (empleado.getNumID()==null) {
            return empleadoRepositorio.save(empleado);
        }else{
            Optional<Empleado> consulta=empleadoRepositorio.getEmpleado(empleado.getNumID());
            if (consulta.isEmpty()) {
                return empleadoRepositorio.save(empleado);
            } else {
                return empleado;
            }
        }
    }

    public Empleado update(Empleado dpto){
        if (dpto.getNumID()!=null){
            Optional<Empleado> consulta=empleadoRepositorio.getEmpleado(dpto.getNumID());
            if(!consulta.isEmpty()){
                if (dpto.getNombre()!=null){
                    consulta.get().setNombre(dpto.getNombre());
                }
                if (dpto.getEdad()!=null) {
                    consulta.get().setEdad(dpto.getEdad());
                }
                if (dpto.getCiudad()!=null) {
                    consulta.get().setCiudad(dpto.getCiudad());
                }
                if (dpto.getSalario()!=null) {
                    consulta.get().setSalario(dpto.getSalario());
                }
                return empleadoRepositorio.save(consulta.get());
            }
        }
        return dpto;
    }

    public boolean deleteEmpleado(int id){
        Optional<Empleado> consulta=empleadoRepositorio.getEmpleado(id);
        if (!consulta.isEmpty()) {
            empleadoRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }
}
