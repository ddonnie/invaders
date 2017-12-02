package rb142.pogorelaya.app.services.impl;

import rb142.pogorelaya.app.dto.InputDTO;
import rb142.pogorelaya.app.dto.ResultDTO;
import rb142.pogorelaya.app.services.SearchService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public ResultDTO search(InputDTO inputDTO) {

        ResultDTO result = new ResultDTO();
        result.setMapId(inputDTO.getSituation().getId());

        List<String> inputMap;
        inputMap = Arrays.asList(inputDTO.getSituation().getMap().split("\\n"));

        Map<String, String> invadersStringed = inputDTO.getInvaders();
        Map<String, String[]> invadersArrayed = new HashMap<>();

        for (Map.Entry<String, String> invader : invadersStringed.entrySet()) {
            invadersArrayed.put(invader.getKey(), invader.getValue().split("\\n"));
        }

        for (int y = 0; y < inputMap.size(); y++) {
            for (Map.Entry<String, String[]> invader : invadersArrayed.entrySet()) {
                if (invader.getValue().length <= (inputMap.size() - y - 1)) {
                    int x = checkForInvader(invader.getValue(), y, inputMap);
                    if (x >= 0) {
                        System.out.println("INVADER FOUND!");
                        System.out.println("invader type " + invader.getKey() + "\ninvader coords: " + x + ":" + y);
                        ResultDTO.DetectedInvaders foundInvader = new ResultDTO.DetectedInvaders();
                        foundInvader.setName(invader.getKey());
                        foundInvader.setX(x);
                        foundInvader.setY(y);
                        result.getDetectedInvaders().add(foundInvader);
                    }
                }
            }
        }

        return result;
    }

    private int checkForInvader(String[] face, int y, List<String> inputMap) {
        int prevX = inputMap.get(y).indexOf(face[0]);
        if (prevX >= 0) {
            for (String faceLayer : face) {
                int currX = inputMap.get(y).indexOf(faceLayer);
                if (currX == prevX) {
                    y++;
                } else {
                    return -1;
                }
            }
            return prevX;
        }
        return -1;
    }
}
