package vsu.ru.astanina.barbershop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "service", schema = "public")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int service_id;

    @Column(name = "serv_name")
    @NotEmpty(message = "Name can not be empty")
    @Size(max = 50, message = "Name length should be between 1 an 100 characters")
    private String serv_name;

    @Column(name = "duration")
    @NotEmpty(message = "duration can not be empty")
    private int duration;

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public void setServ_name(String serv_name) {
        this.serv_name = serv_name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getService_id() {
        return service_id;
    }

    public String getServ_name() {
        return serv_name;
    }

    public int getDuration() {
        return duration;
    }
}
