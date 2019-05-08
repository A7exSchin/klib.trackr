package klib.trackr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Waypoint {

    //private Long linkId;
    private String type;

    public Waypoint() {
    }

   // public Long getlinkId() {
    //    return this.linkId;
   // }

    public String getRoute() {
        return this.type;
    }

//    public void setlinkId(Long linkId) {
//        this.linkId = linkId;
//    }

    public void setRoute(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "id=leer" + '\'' +
                ", type='" + type + 
                '}';
    }
}