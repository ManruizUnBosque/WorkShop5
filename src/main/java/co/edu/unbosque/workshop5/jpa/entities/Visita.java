package co.edu.unbosque.workshop5.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "Visita")
public class Visita {
    @Id
    @GeneratedValue
    @Column(name = "visita_id")
    private Integer visitId;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Pattern(regexp = "steri|mcImp|vacc|deworm|urg|ctrl", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Mascota mascota;

    public Visita() {}

    public Visita(Integer visitId, String type, String description) {
        this.visitId = visitId;
        this.createdAt = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.type = type;
        this.description = description;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Veterinario getVet() {
        return veterinario;
    }

    public void setVet(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Mascota getPet() {
        return mascota;
    }

    public void setPet(Mascota mascota) {
        this.mascota = mascota;
    }
}
