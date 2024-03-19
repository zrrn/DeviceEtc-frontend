package model;

import java.time.LocalDateTime;

public class Device {
	    private Long id;
	    private String name;
	    private String description;
	    private Double longitude;
	    private Double altitude;
	    private Integer period;
	    private Double distance;
	    private LocalDateTime lastNotify;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Double getLongitude() {
			return longitude;
		}
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}
		public Double getAltitude() {
			return altitude;
		}
		public void setAltitude(Double altitude) {
			this.altitude = altitude;
		}
		public Integer getPeriod() {
			return period;
		}
		public void setPeriod(Integer period) {
			this.period = period;
		}
		public Double getDistance() {
			return distance;
		}
		public void setDistance(Double distance) {
			this.distance = distance;
		}
		public LocalDateTime getLastNotify() {
			return lastNotify;
		}
		public void setLastNotify(LocalDateTime lastNotify) {
			this.lastNotify = lastNotify;
		}
}
