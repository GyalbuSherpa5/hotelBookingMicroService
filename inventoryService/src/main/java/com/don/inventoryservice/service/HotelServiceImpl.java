package com.don.inventoryservice.service;

import com.don.inventoryservice.dto.hotel.HotelRequestDto;
import com.don.inventoryservice.dto.hotel.HotelResponseDto;
import com.don.inventoryservice.mapper.HotelToResponseMapper;
import com.don.inventoryservice.model.hotel.Contact;
import com.don.inventoryservice.model.hotel.Hotel;
import com.don.inventoryservice.model.hotel.HotelImage;
import com.don.inventoryservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelToResponseMapper hotelMapper;
    @Override
    public void saveHotel(HotelRequestDto hotelRequestDto,
                          String path,
                          List<MultipartFile> hotelImages) throws IOException {

        String relativePath = path + "images/" + hotelRequestDto.getHotelName();
        String absolutePath = System.getProperty("user.dir") + File.separator + relativePath;

        File filePath = new File(absolutePath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        List<HotelImage> imagesToSave = new ArrayList<>();

        for (MultipartFile image : hotelImages) {
            Files.copy(image.getInputStream(),
                    Paths.get(absolutePath, image.getOriginalFilename()));
            HotelImage imageMultiPartToImage = new HotelImage();

            imageMultiPartToImage.setHotelImageUrl(
                    relativePath + File.separator + image.getOriginalFilename());

            imagesToSave.add(imageMultiPartToImage);
        }

        List<Contact> contacts = hotelRequestDto.getContacts();

        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelRequestDto.getHotelName());
        hotel.setDescription(hotelRequestDto.getDescription());
        hotel.setImages(imagesToSave);
        hotel.setContacts(contacts);
        hotel.setAddress(hotelRequestDto.getAddress());

        hotelRepository.save(hotel);
    }

    @Override
    public List<HotelResponseDto> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelMapper)
                .collect(Collectors.toList());
    }
}
