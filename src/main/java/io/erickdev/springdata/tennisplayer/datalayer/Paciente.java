package io.erickdev.springdata.tennisplayer.datalayer;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.StringJoiner;
@Entity
@Table(schema = "prueba", name = "paciente")
@Repository
public class Paciente {
    @Id
    @GeneratedValue
    private int id;
    private String nombres;
    private Date cita;
    private int celular;

    public Paciente() {
    }

    public Paciente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getCita() {
        return cita;
    }

    public void setCita(Date cita) {
        this.cita = cita;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Paciente.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nombres='" + nombres + "'")
                .add("cita='" + cita + "'")
                .add("celular='" + celular + "'")
                .toString();
    }
}
