package com.nc.defo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "t_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String getAuthority() {
        return getName();
    }
}
