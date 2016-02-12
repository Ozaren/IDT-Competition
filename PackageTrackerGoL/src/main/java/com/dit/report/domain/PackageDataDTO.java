package com.dit.report.domain;
 
import com.dit.report.domain.Event;
import com.dit.report.service.EventServiceImpl;
import com.dit.report.util.Calculator;
import com.dit.report.util.DeliveryStatus;
import com.google.common.base.Objects;
import java.util.List;
import java.util.ArrayList;
 
import java.security.Timestamp;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
 
public class PackageDataDTO {
 
    private String name;
    private String uuid; 
    private double startLat;
               private double startLon;
               private double destinationLat;
               private double destinationLon;
              
               private double distance2Travel = 0;                         
               //private Double estimatedDeliverTime;
               private String estimatedDeliverTime;
               private DeliveryStatus status;
 
              
               private static final Logger LOGGER = LoggerFactory.getLogger(PackageDataDTO.class);
                  
                
               public PackageDataDTO(PackageData pData){
                              this.name = pData.getName();
                              this.uuid = pData.getUuid();
                             
                              Event event = pData.getEventList().get(0);
                              this.startLat= event.getLat();
                              this.startLon = event.getLon();
                             
                              this.destinationLat = pData.getDestinationLat();
                              this.destinationLon = pData.getDestinationLon();
                             
                              this.distance2Travel = pData.getDistance2Travel();
                              this.estimatedDeliverTime = pData.getEstimatedDeliverTime();
                              this.status = pData.getStatus();                  
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
              
 
 
               public double getStartLat() {
                              return startLat;
               }
              
 
 
               public void setStartLat(double startLat) {
                              this.startLat = startLat;
               }
              
 
 
               public double getStartLon() {
                              return startLon;
               }
              
 
 
               public void setStartLon(double startLon) {
                              this.startLon = startLon;
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
              
              
 
 
}