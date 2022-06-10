package vsu.ru.astanina.barbershop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "room", schema = "public")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    int room_id;

    @Column(name = "room_num")
    @NotEmpty(message = "room_num can not be empty")
    private int room_num;

    @Column(name = "count")
    @NotEmpty(message = "count can not be empty")
    private int count;

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRoom_id() {
        return room_id;
    }

    public int getCount() {
        return count;
    }

    public void setRoom_num(int room_num) {
        this.room_num = room_num;
    }

    public int getRoom_num() {
        return room_num;
    }
}
