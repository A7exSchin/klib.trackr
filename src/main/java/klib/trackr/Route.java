package klib.trackr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

    private Waypoint waypoint;

    public Route() {
    }

    public Waypoint getValue() {
        return waypoint;
    }

    public void setWaypoint(Waypoint waypoint) {
        this.waypoint = waypoint;
    }

    @Override
    public String toString() {
        return "Route{" +
                "waypoint='" + waypoint +
                '}';
    }
}
