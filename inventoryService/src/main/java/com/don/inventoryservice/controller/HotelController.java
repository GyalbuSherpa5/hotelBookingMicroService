package com.don.inventoryservice.controller;

import com.don.inventoryservice.dto.hotel.HotelRequestDto;
import com.don.inventoryservice.dto.hotel.HotelResponseDto;
import com.don.inventoryservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @Value(("${project.image}"))
    private String path;

    @PostMapping("/createHotel")
    public String createHotel(
            @RequestPart HotelRequestDto hotelRequestDto,
            @RequestPart List<MultipartFile> hotelImages) throws IOException {

        hotelService.saveHotel(hotelRequestDto, path, hotelImages);
        return "hotel created successfully";
    }

    @GetMapping("/getHotels")
    public List<HotelResponseDto> getAllHotels(){
        return hotelService.getAllHotels();
    }

}
