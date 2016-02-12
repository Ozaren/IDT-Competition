package com.dit.report.domain;
 
import com.dit.report.domain.Event;
import com.dit.report.service.EventServiceImpl;
import com.dit.report.util.Calculator;
import com.dit.report.util.DeliveryStatus;
import com.google.common.base.Objects;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
 
import java.security.Timestamp;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
 
public class PackageData {
 
    private String name;
    private String uuid;   
    private double destinationLat;
               private double destinationLon;
              
               private double distanceTraveled = 0;        
               private Long timeTraveled = 0L;
               private double distance2Travel = 0; 
               //private Double estimatedDeliverTime;
               private String estimatedDeliverTime;
              
               private DeliveryStatus status = DeliveryStatus.InProgress;
 
               private List<Event> eventList = new ArrayList<Event>();
              
               private static final Logger LOGGER = LoggerFactory.getLogger(PackageData.class);
                  
                
               public PackageData(){
                             
               }
              
    public PackageData(String name, String uuid) {
               this.name = name;
               this.uuid = uuid;
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
                              return destinationLat;
               }
 
               public void setDestinationLat(double destinationLat) {
                              this.destinationLat = destinationLat;
               }
              
               public double getDestinationLon() {
                              return destinationLon;
               }             
 
               public void setDestinationLon(double destinationLon) {
                              this.destinationLon = destinationLon;
               }
              
               public double getDistanceTraveled() {
                              return distanceTraveled;
               }
 
               public void setDistanceTraveled(Float distanceTraveled) {
                              this.distanceTraveled = distanceTraveled;
               }
              
               public double getDistance2Travel() {
				return distance2Travel;
               }
	
				public void setDistance2Travel(double distance2Travel) {
					this.distance2Travel = distance2Travel;
				}

			public String getEstimatedDeliverTime() {
                              return estimatedDeliverTime;
               }
              
               public void setEstimatedDeliverTime(String estimatedDeliverTime) {
                              this.estimatedDeliverTime = estimatedDeliverTime;
               }             
 
               public DeliveryStatus getStatus() {
                              return status;
               }
              
               public void setStatus(DeliveryStatus status) {
                              this.status = status;
               }
 
               public void addEvent2List(Event event) {
                              int size = eventList.size();
                             
                              //the first event
                              if(size == 0){                                     
                                             calculateTime(event, event);
                              } else if(size > 0){               //the second event and afterwards
                                             Event pEvent = eventList.get(size-1);
                                             calculateTime(pEvent, event);
                              }
                             
                              eventList.add(event);
               }
 
               public int getEventListSize(){
                              return eventList.size();
               }
              
               public List<Event> getEventList(){
                              return eventList;
               }
              
               //first event has estimatedDeliverTime as null
               //second event and events afterwards has both distance2Travle and estimatedDeliverTime
               private void calculateTime(Event pEvent, Event cEvent){
                   			long estimatedTimeNeeded  = 0L; 
                   			distance2Travel = Calculator.getDistance(cEvent.getLat(), cEvent.getLon(), destinationLat, destinationLon, "M");                                   
                             
                              //only calculate speed and estimated time if it is second event and event afterwards
                              if(pEvent!=cEvent){                                       
                                             double shortDist = Calculator.getDistance(pEvent.getLat(), pEvent.getLon(), cEvent.getLat(), cEvent.getLon(), "M");
                                             distanceTraveled += shortDist;
                                             //timeTraveled = timeTraveled +10;
                                             timeTraveled += Calculator.getEventInterval(pEvent.getTime(), cEvent.getTime());
                                             double averageSpeed = distanceTraveled/timeTraveled;
                                             estimatedTimeNeeded = (long) Math.ceil(distance2Travel/averageSpeed); //round up milliseconds
                                             //time2arrive = cEvent.getTime() + timeNeeded;
                                             estimatedDeliverTime = Calculator.getEstimatedDTime(cEvent.getTime(), estimatedTimeNeeded); 
                                             //estimatedDeliverTime = distance2Travel/averageSpeed;
                              }
                             
                              LOGGER.debug("$$$$$$$$$$ distance2travel: " + distance2Travel + ", time: " + estimatedDeliverTime);
               }
 
}