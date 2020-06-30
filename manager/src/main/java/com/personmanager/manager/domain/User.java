package com.personmanager.manager.domain;

import com.personmanager.manager.domain.audit.UserDateAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@Entity
@Table(name = "USER", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends UserDateAudit {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;


    @Column(name = "IS_ACTIVE")
    private boolean isActive = Boolean.TRUE;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, name);
    }

}
