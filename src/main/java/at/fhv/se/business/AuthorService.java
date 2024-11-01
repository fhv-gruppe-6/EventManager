package at.fhv.se.business;

import at.fhv.se.business.dto.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {


    public List<AuthorDTO> getAuthors() {
        // TODO: get all authors from DB (or domain model) and map them to AuthorDTOs
        return Arrays.asList(new AuthorDTO(1L, "einstein"), new AuthorDTO(2L,"gödel"));
    }
}
