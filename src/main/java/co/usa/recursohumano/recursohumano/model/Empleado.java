package co.usa.recursohumano.recursohumano.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numID;
    private String nombre;
    private Integer edad;
    private String ciudad;
    private Integer salario;

    @OneToOne
    @JoinColumn(name = "departamento_id")
    @JsonIgnoreProperties("empleados") //esto permite evitar un cilo infinito entre la relacion de las dos tablas
    private Departamento departamento;

    public Integer getNumID() {
        return numID;
    }
    public void setNumID(Integer numID) {
        this.numID = numID;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Integer getSalario() {
        return salario;
    }
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }



    
}
