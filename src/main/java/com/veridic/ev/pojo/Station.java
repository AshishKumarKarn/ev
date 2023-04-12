package com.veridic.ev.pojo;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ev_station")
public class Station {
    @Column(name = "station_id")
    @Id
    @GeneratedValue
    private Long stationId;
    @Column(name = "station_name")
    private String stationName;

    /**
     * Location of image stored in S3/NAS
     * */
    @Column(name = "station_image")
    private String stationImage;
    @Column(name = "station_pricing")
    private String stationPricing;
    @Column(name = "station_address")
    private String stationAddress;
}
