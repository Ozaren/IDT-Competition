package com.dit.report.domain;
 
import com.dit.report.util.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.google.common.base.Objects;
 
@JsonFilter("eventFilter")
public class Event {
 
               private String name;
               private String uuid;
               private double lat;
               private double lon;
               private int ele;
               private String time;
               private Boolean delivered;
 
               private DeliveryStatus status = DeliveryStatus.InProgress;
              
               public Event() {
               }
 
               public boolean isNewPackage(){
                              if (name!=null)
                                             return true;
                              else
                                             return false;
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
              
 
               public double getLat() {
                              return lat;
               }
 
               public void setLat(double lat) {
                              this.lat = lat;
               }
 
               public double getLon() {
                              return lon;
               }
 
               public void setLon(double lon) {
                              this.lon = lon;
               }
 
               public int getEle() {
                              return ele;
               }
 
               public void setEle(int ele) {
                              this.ele = ele;
               }
 
              
               public String getTime() {
                              return time;
               }
              
 
               public void setTime(String time) {
                              this.time = time;
               }
              
 
               public boolean isDelivered() {
                              if (delivered == null)
                                             return false;
                             
                              return delivered.booleanValue();
               }
              
 
               public void setDelivered(Boolean delivered) {
                              this.delivered = delivered;
                             
                              if(delivered)
                                             status = DeliveryStatus.Delivered;
                              else
                                             status = DeliveryStatus.InProgress;
               }
              
               public DeliveryStatus getStatus() {
                              return status;
               }
              
               public void setStatus(DeliveryStatus status) {
                   this.status = status;
               }
               
               @Override
               public String toString() {
                              return Objects.toStringHelper(this).add("name", name).add("uuid", uuid).add("lat", lat).add("lon", lon)
                                                            .add("ele", ele).add("time", time).add("status", status).add("delivered", delivered).toString();
               }
}