package rb142.pogorelaya.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rb142.pogorelaya.app.dto.InputDTO;
import rb142.pogorelaya.app.dto.ResultDTO;
import rb142.pogorelaya.app.services.SearchService;

import java.io.IOException;

@RestController
@RequestMapping(value = "/")
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping("/api/searchInvaders")
    public ResultDTO searchInvaders(@RequestBody InputDTO inputDTO)
            throws IOException {
        ResultDTO response;
        response = searchService.search(inputDTO);
        return response;
    }

}
