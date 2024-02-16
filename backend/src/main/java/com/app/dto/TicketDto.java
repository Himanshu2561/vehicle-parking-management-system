package com.app.dto;

import com.app.pojo.VehicleType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TicketDto {
    private int id;
    private Date date;
    private String vehicleNumber;
    private int slotNumber;
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    public TicketDto(int id, Date date, String vehicleNumber, int slotNumber, VehicleType type) {
        this.id = id;
        this.date = date;
        this.vehicleNumber = vehicleNumber;
        this.slotNumber = slotNumber;
        this.type = type;
    }
}
