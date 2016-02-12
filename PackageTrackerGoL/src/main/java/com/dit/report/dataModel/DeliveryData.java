package com.dit.report.dataModel;
 
import java.util.Hashtable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
import com.dit.report.domain.Event;
import com.dit.report.domain.PackageData;
import com.dit.report.util.DeliveryStatus;
 
@Component
@Scope("application")
public class DeliveryData {
               private Hashtable<String, PackageData> packageDataHT = new Hashtable<String, PackageData>();              
              
               private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryData.class);
                  
               public DeliveryData(){
                             
               }
 
               public void addData(PackageData data){
                              packageDataHT.put(data.getUuid(), data);
               }
              
               public void updateData(Event event){
                              PackageData pData = packageDataHT.get(event.getUuid());
                              pData.addEvent2List(event);
                              
                              //it seems the simulator send last event after the delivery confirmation, adjust the event status accordingly, so that UI map data retrieve interval can be stopped
                              if (pData.getStatus().equals(DeliveryStatus.Delivered))
                            	  event.setStatus(pData.getStatus());
                              
                              LOGGER.debug("#################### event: " + event);
               }
              
               public void updateDataStatus(Event event){
                              PackageData pData = packageDataHT.get(event.getUuid());
                              pData.setStatus(event.getStatus());
                             
                              //update last event status to delivered, to do: do we need both last two event has delivered status? (refer ln34) 
                              List<Event> eventList = pData.getEventList();
                              eventList.get(eventList.size()-1).setStatus(pData.getStatus());
                              
                              LOGGER.debug("$$$$$$$$$$$$ package size: " + packageDataHT.size());
                              LOGGER.debug("$$$$$$$$$$$$ event size: " + pData.getEventListSize());
                              LOGGER.debug("$$$$$$$$$$$$$ last event: " + eventList.get(eventList.size()-1));
               }
 
               public Hashtable<String, PackageData> getPackageDataHT() {
                              return packageDataHT;
               }
              
}