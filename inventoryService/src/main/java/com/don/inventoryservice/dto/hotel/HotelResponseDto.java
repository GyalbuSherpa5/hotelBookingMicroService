package com.don.inventoryservice.dto.hotel;

import com.don.inventoryservice.model.hotel.Address;
import com.don.inventoryservice.model.hotel.Contact;
import com.don.inventoryservice.model.hotel.HotelImage;
import com.don.inventoryservice.model.room.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponseDto {
    private String hotelName;
    private String description;
    private String ownerName;
    private List<HotelImage> images;
    private List<Contact> contacts;
    private Address address;
    private List<Room> rooms;
}
