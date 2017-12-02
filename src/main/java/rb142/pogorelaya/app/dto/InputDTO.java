package rb142.pogorelaya.app.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Map;

public class InputDTO {

    private Map<String, String> invaders;

    private Situation situation;

    public InputDTO() {
    }

    public Map<String, String> getInvaders() {
        return invaders;
    }

    public void setInvaders(Map<String, String> invaders) {
        this.invaders = invaders;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    @JsonRootName(value = "situation")
    public static class Situation {

        private String id;
        private String map;
        private String date;
        private int height;
        private int width;

        public Situation() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMap() {
            return map;
        }

        public void setMap(String map) {
            this.map = map;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
