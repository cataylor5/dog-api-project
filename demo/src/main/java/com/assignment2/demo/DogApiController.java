package com.assignment2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DogApiController {

    private final RestTemplate restTemplate;

    // Inject RestTemplate
    @Autowired
    public DogApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/dogs")
    public List<DogImage> getDogs() {
        // URL of The Dog API
        String apiUrl = "https://api.thedogapi.com/v1/images/search?limit=5";

        // Make API call and map JSON to DogImage array
        DogImage[] dogImages = restTemplate.getForObject(apiUrl, DogImage[].class);

        // Return as a list
        return Arrays.asList(dogImages);
    }

    @GetMapping("/dogs/breed")
    public List<DogImage> getDogsByBreed(@RequestParam String breedName) {
        // Step 1: Get all breeds
        String breedsUrl = "https://api.thedogapi.com/v1/breeds";
        Breed[] breeds = restTemplate.getForObject(breedsUrl, Breed[].class);

        // Step 2: Find the breed ID for the given breed name
        String breedId = null;
        for (Breed breed : breeds) {
            if (breed.getName().equalsIgnoreCase(breedName)) {
                breedId = breed.getId();
                break;
            }
        }

        // Step 3: Return an empty list if the breed is not found
        if (breedId == null) {
            return new ArrayList<>();
        }

        // Step 4: Fetch images for the breed ID
        String imagesUrl = "https://api.thedogapi.com/v1/images/search?breed_ids=" + breedId;
        DogImage[] dogImages = restTemplate.getForObject(imagesUrl, DogImage[].class);

        return Arrays.asList(dogImages);
    }

    @GetMapping("/dogs/all-breeds")
    public List<String> getAllBreeds() {
        // Fetch all breeds from The Dog API
        String breedsUrl = "https://api.thedogapi.com/v1/breeds";
        Breed[] breeds = restTemplate.getForObject(breedsUrl, Breed[].class);

        // Extract breed names into a list
        List<String> breedNames = new ArrayList<>();
        for (Breed breed : breeds) {
            breedNames.add(breed.getName());
        }

        // Return the list of breed names
        return breedNames;
    }
}
