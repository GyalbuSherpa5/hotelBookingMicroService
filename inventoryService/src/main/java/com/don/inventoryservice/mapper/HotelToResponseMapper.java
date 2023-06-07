package com.don.inventoryservice.mapper;

import com.don.inventoryservice.dto.hotel.HotelResponseDto;
import com.don.inventoryservice.model.hotel.Hotel;
import com.don.inventoryservice.model.hotel.HotelImage;
import com.don.inventoryservice.model.room.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class HotelToResponseMapper implements Function<Hotel, HotelResponseDto> {

    @Override
    public HotelResponseDto apply(Hotel hotel) {

        List<HotelImage> images = hotel.getImages();
        List<HotelImage> newImages = new ArrayList<>();

        for (HotelImage image : images) {

            String saveImagePath = image.getHotelImageUrl().replace("inventoryService/src/main/resources/static/","");

            HotelImage image1 = new HotelImage();
            image1.setHotelImageUrl("http://localhost:8080/" + saveImagePath);
            image1.setHotelImageId(image.getHotelImageId());

            newImages.add(image1);
        }

        List<Room> rooms = new ArrayList<>();

        return new HotelResponseDto(
                hotel.getHotelName(),
                hotel.getDescription(),
                hotel.getOwnerName(),
                newImages,
                hotel.getContacts(),
                hotel.getAddress(),
                rooms
        );
    }
}
