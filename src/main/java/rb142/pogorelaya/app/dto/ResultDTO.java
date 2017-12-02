package rb142.pogorelaya.app.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

public class ResultDTO {

    String mapId;
    List<DetectedInvaders> detectedInvaders;

    public ResultDTO() {
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public List<DetectedInvaders> getDetectedInvaders() {
        return detectedInvaders;
    }

    public void setDetectedInvaders(List<DetectedInvaders> detectedInvaders) {
        this.detectedInvaders = detectedInvaders;
    }

    @JsonRootName(value = "detectedInvaders")
    public static class DetectedInvaders {

        String name;
        int x;
        int y;

        public DetectedInvaders() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
