package co.edu.unbosque.workshop5.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "UserApp.findAll", query = "Selecciona usuario"),
        @NamedQuery(name = "UserApp.findByRole", query = "Selecciona usuario desde user.role = :role")
})
public abstract class Usuario {
    @Id @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false, updatable = false)
    private String password;

    @Email @Column(nullable = false)
    private String email;

    @Pattern(regexp = "dueño|official|vet", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(nullable = false, updatable = false)
    private String role;

    public Usuario(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Usuario() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

