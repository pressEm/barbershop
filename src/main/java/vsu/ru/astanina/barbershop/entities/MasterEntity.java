package vsu.ru.astanina.barbershop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "master", schema = "public")
public class MasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "master_id")
    int master_id;

    @Column(name = "master_name")
    @NotEmpty(message = "master_name can not be empty")
    @Size(max = 50, message = "master_name length should be between 1 an 100 characters")
    private String master_name;


    @ManyToOne()
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    RoomEntity room_id;

    public int getMaster_id() {
        return master_id;
    }

    public String getMaster_name() {
        return master_name;
    }

    public RoomEntity getRoom_id() {
        return room_id;
    }

    public void setMaster_id(int master_id) {
        this.master_id = master_id;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public void setRoom_id(RoomEntity room_id) {
        this.room_id = room_id;
    }

//    @ManyToOne()
//    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
//    ServiceEntity service;
//
//    @ManyToOne()
//    @JoinColumn(name = "app_id", referencedColumnName = "app_id")
//    ApplicationEntity app;

}