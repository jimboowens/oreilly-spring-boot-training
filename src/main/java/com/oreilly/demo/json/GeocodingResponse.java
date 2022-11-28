


package com.oreilly.demo.json;

import java.util.List;

public class GeocodingResponse {

    private List<GeocodingResult> results;
    private String status;

    public List<GeocodingResult> getResults() {
        return results;
    }

    public void setResults(List<GeocodingResult> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Location getLocation() {
        return results.get(0).getGeometry().getLocation();
    }

    public String getFormattedAddress() {
        return results.get(0).getFormattedAddress();
    }

    @Override
    public String toString() {
        return "GeocodingResponse{" +
                "results=" + results +
                ", status='" + status + '\'' +
                '}';
    }
}
