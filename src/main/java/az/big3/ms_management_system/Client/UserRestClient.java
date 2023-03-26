package az.big3.ms_management_system.Client;


import az.big3.ms_management_system.Dto.UserDTO;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserRestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.base.url}")
    private String baseUrl;

    public List<UserDTO> getAllUsers() {
        String url = baseUrl + "/users";
        ResponseEntity<List<UserDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDTO>>() {});
        return response.getBody();
    }

    public UserDTO getUserById(Long id) {
        String url = baseUrl + "/users/" + id;
        ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);
        return response.getBody();
    }

    public UserDTO createUser(UserDTO userDTO) {
        String url = baseUrl + "/users";
        HttpEntity<UserDTO> request = new HttpEntity<>(userDTO);
        ResponseEntity<UserDTO> response = restTemplate.postForEntity(url, request, UserDTO.class);
        return response.getBody();
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        String url = baseUrl + "/users/" + id;
        HttpEntity<UserDTO> request = new HttpEntity<>(userDTO);
        ResponseEntity<UserDTO> response = restTemplate.exchange(url, HttpMethod.PUT, request, UserDTO.class);
        return response.getBody();
    }

    public void deleteUser(Long id) {
        String url = baseUrl + "/users/" + id;
        restTemplate.delete(url);
    }

}
