package com.don.inventoryservice.service;

import com.don.inventoryservice.dto.hotel.HotelRequestDto;
import com.don.inventoryservice.dto.hotel.HotelResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HotelService {
    void saveHotel(HotelRequestDto hotelRequestDto, String path, List<MultipartFile> hotelImages) throws IOException;
    List<HotelResponseDto> getAllHotels();
}
