package gameOfLife.packageTracker.shipping.updated;

import java.util.ArrayList;
//import com.google.common.base.Objects;
import java.util.List;

import gameOfLife.packageTracker.util.Calculator;
import gameOfLife.packageTracker.util.DeliveryStatus;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
public class PackageData {
	private String				name;
	private String				uuid;
	private double				distanceTraveled	= 0;
	private double				timeTraveled		= 0;
	private DeliveryStatus	status				= DeliveryStatus.InProgress;
	private List<Event>		eventList			= new ArrayList<>();
	private Event				currentPosition , endPosition;
//	private static final Logger	LOGGER				= LoggerFactory.getLogger(PackageData.class);
	
	public PackageData(double endX , double endY , String name , String uuid) {
		this.name = name;
		this.uuid = uuid;
		this.currentPosition = null;
		this.endPosition = new Event(this , endX , endY);
		endPosition.setUuid(uuid);
		endPosition.setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public double getDestinationLat() {
		return endPosition.getLat();
	}
	
	public void setDestinationLat(double destinationLat) {
		endPosition.setLat(destinationLat);
	}
	
	public double getDestinationLon() {
		return endPosition.getLon();
	}
	
	public void setDestinationLon(double destinationLon) {
		endPosition.setLon(destinationLon);
	}
	
	public Event getDestination() {
		return endPosition;
	}
	
	public Double getEstimatedDeliverTime() {
		return cacluateTime();
	}
	
	public double getDistanceToTravel() {
		return Calculator.getDistance(currentPosition , endPosition);
	}
	
	public double getDistanceToTravel(String units) {
		return Calculator.getDistance(currentPosition , endPosition , units);
	}
	
	public DeliveryStatus getStatus() {
		return status;
	}
	
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
	
	public boolean addEventToList(Event event) {
		int size = eventList.size();
		//the first event
		if(size == 0 || eventList.get(size - 1).getTime() < event.getTime()) {
			eventList.add(event);
			return true;
		}
		return false;
	}
	
	public int getEventListSize() {
		return eventList.size();
	}
	
	public List<Event> getEventList() {
		return eventList;
	}
	
	//first event has estimatedDeliverTime as null
	//second event and events afterwards has both distance2Travle and estimatedDeliverTime
	public double calculateTime(Event currentEvent) {
		if(addEventToList(currentEvent)) {
			currentPosition = currentEvent;
			return cacluateTime();
		}
		else {
			return -1;
		}
//		LOGGER.debug("$$$$$$$$$$ distance2travel: " + distance2Travel + ", time: " + estimatedDeliverTime);
	}
	
	private double cacluateTime() {
		if(eventList.size() < 2)
			return -1;
		double estimatedDeliverTime = -1;
		double averageSpeed = -1;
		//only calculate speed and estimated time if it is second event and event afterwards
		distanceTraveled = 0;
		timeTraveled = 0;
		Event last = null;
		for(Event e: eventList) {
			if(last != null) {
				distanceTraveled += Calculator.getDistance(e , last);
				timeTraveled += e.getTime() - last.getTime();
			}
			last = e;
		}
		if(timeTraveled != 0) {
			averageSpeed = distanceTraveled / timeTraveled;
			if(averageSpeed != 0) {
				estimatedDeliverTime = getDistanceToTravel() / averageSpeed;
			}
		}
		return estimatedDeliverTime;
	}
}
