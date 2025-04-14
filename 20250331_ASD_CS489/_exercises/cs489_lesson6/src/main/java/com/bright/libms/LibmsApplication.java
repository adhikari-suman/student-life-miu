package com.bright.libms;

import com.bright.libms.dto.request.AddressRequestDto;
import com.bright.libms.dto.request.PublisherRequestDto;
import com.bright.libms.dto.response.PublisherResponseDto;
import com.bright.libms.model.Publisher;
import com.bright.libms.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class LibmsApplication {

    private final PublisherService publisherService;

    public static void main(String[] args) {
        SpringApplication.run(LibmsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            //Create PublisherRequestDto
            PublisherRequestDto publisherRequestDto = new PublisherRequestDto(
                    "Apress",
                    new AddressRequestDto(
                            "1A",
                            "LLC One New York Plaza",
                            "New York",
                            "NY",
                            1562
                    )
            );
            System.out.println(publisherService.createPublisher(publisherRequestDto));
            System.out.println("Publisher by name: "+publisherService.findPublisherByName("Apress"));

            System.out.println("Find all publishers");
            System.out.println(publisherService.findAllPublishers());

            System.out.println("Publisher by name: "+publisherService.findPublisherByName("Apress"));

            System.out.println("Update publisher");

            AddressRequestDto addressRequestDto = new AddressRequestDto(
                    "1","100 N 4 st","Fairfield","IA", 52556
            );
            PublisherRequestDto updatePublisherRequestDTO = new PublisherRequestDto("Appress 911", addressRequestDto);

            Optional<PublisherResponseDto> updatedPublisher = publisherService.updatePublisher("Apress",
                                                                                               updatePublisherRequestDTO);

            System.out.println("Updated publisher: "+updatedPublisher.get());


            System.out.println("Delete publisher by name: Appress 911");
            publisherService.deletePublisherByName("Appress 911");

            System.out.println("Find all publishers");
            System.out.println(publisherService.findAllPublishers());
        };
    }
}
