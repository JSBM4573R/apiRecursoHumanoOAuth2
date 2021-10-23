package co.usa.recursohumano.recursohumano.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="departamento") 
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numID;
    private String nombreDepartamento;
    private Date fechaCreacionDate;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "departamento")
    @JsonIgnoreProperties("departamento") //esto permite evitar un cilo infinito entre la relacion de las dos tablas
    private List <Empleado> empleados;

    public Integer getNumID(){
        return numID;
    }
    public void setNumID(Integer numID) {
        this.numID = numID;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    public Date getFechaCreacionDate() {
        return fechaCreacionDate;
    }
    public void setFechaCreacionDate(Date fechaCreacionDate) {
        this.fechaCreacionDate = fechaCreacionDate;
    }
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    


}
