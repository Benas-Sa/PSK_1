package main.back.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Clinic.findAll", query = "select t from Clinic as t")
})
@Table(name = "CLINIC")

@Getter @Setter

public class Clinic {

    public Clinic(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    private List<Patient> patients = new ArrayList<>();

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return Objects.equals(name, clinic.name);
    }

    @Override
    public int hashCode(){

        return Objects.hash(name);
    }


}
