package vsu.ru.astanina.barbershop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "serv_app", schema = "public")
public class Serv_App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne()
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    ServiceEntity service;

    @ManyToOne()
    @JoinColumn(name = "app_id", referencedColumnName = "app_id")
    ApplicationEntity app;

}
