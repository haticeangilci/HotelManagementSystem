package com.tpe.hotelManagementSystem.domain;
//2.hotel isimli bir class oluşturduk ve bu class entegre edebilmek için Entity ve Table anatasyonlarını kullandık.


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_hotels")
public class Hotel {
    //3.adım primary key yani id oluşturalım.
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)//id değerinin otomatik olarak artmasını sağlar
    private Long id;//manuel numaralandıralım.. Otomatik şimdilik üstteki kod pasifleştirelim.
    @Column(nullable = false)
    private String name;
    @Column (nullable = false)
    private String location;

    // A oteli odaları :11-12-13
    //oda listesinden 11 i çıkarsam:11-12-13--->room tablosunda kalmaya devam etsin. geriye dönük bilgileri kalsın istiyoruz.
    //orphanremoval : 11 i tablodan tamamen siler geriye dönük bilgi kalmaz
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<Room> rooms=new ArrayList<>();//Bir hotelin birden fazla odaları olabilir.

    //5.adım değer atamasını kolaylaştırmak için constructor

    public Hotel(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
