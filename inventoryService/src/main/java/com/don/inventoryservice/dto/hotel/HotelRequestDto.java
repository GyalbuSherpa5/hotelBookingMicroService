package com.don.inventoryservice.dto.hotel;

import com.don.inventoryservice.model.hotel.Address;
import com.don.inventoryservice.model.hotel.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequestDto {
    private String hotelName;
    private String description;
    private List<Contact> contacts;
    private Address address;
}
