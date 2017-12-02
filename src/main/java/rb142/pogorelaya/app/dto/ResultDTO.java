package rb142.pogorelaya.app.dto;

import java.util.List;

public class ResultDTO {

    String mapId;
    List<DetectedInvaderDTO> detectedInvaders;

    public ResultDTO() {
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public List<DetectedInvaderDTO> getDetectedInvaders() {
        return detectedInvaders;
    }

    public void setDetectedInvaders(List<DetectedInvaderDTO> detectedInvaders) {
        this.detectedInvaders = detectedInvaders;
    }
}
