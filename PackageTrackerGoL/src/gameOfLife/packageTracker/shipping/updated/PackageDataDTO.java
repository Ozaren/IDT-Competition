package gameOfLife.packageTracker.shipping.updated;

//import javax.persistence.Column;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
public class PackageDataDTO {
	private PackageData	packageData;
	private double			distance2Travel	= 0;
	private Double			estimatedDeliverTime;
	
	public PackageDataDTO(PackageData packageData) {
		this.packageData = packageData;
		this.distance2Travel = packageData.getDistanceToTravel();
		this.estimatedDeliverTime = packageData.getEstimatedDeliverTime();
	}
	
	public PackageData getPackageData() {
		return packageData;
	}
	
	public double getStartLat() {
		return packageData.getEventList().get(0).getLat();
	}
	
	public double getStartLon() {
		return packageData.getEventList().get(0).getLon();
	}
	
	public double getDistance2Travel() {
		return distance2Travel;
	}
	
	public void setDistance2Travel(double distance2Travel) {
		this.distance2Travel = distance2Travel;
	}
	
	public Double getEstimatedDeliverTime() {
		return estimatedDeliverTime;
	}
	
	public void setEstimatedDeliverTime(Double estimatedDeliverTime) {
		this.estimatedDeliverTime = estimatedDeliverTime;
	}
}
