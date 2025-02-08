# Dog API Project

This project is a Spring Boot application that interacts with The Dog API to fetch and display information about dogs. It includes endpoints to fetch random images, search for dog breeds, and list all available breeds.

## Features
1. **Fetch Random Dog Images**:
   - **Endpoint**: `/api/dogs`
   - **Method**: GET
   - **Description**: Returns 5 random dog images.

2. **Search by Breed**:
   - **Endpoint**: `/api/dogs/breed?breedName=<breed_name>`
   - **Method**: GET
   - **Description**: Fetches images of dogs based on the provided breed name.
   - **Example**: `/api/dogs/breed?breedName=Maltese`

3. **List All Breeds**:
   - **Endpoint**: `/api/dogs/all-breeds`
   - **Method**: GET
   - **Description**: Returns a list of all available dog breeds.

## How to Run the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/cataylor5/dog-api-project.git
