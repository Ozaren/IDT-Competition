package com.dit.report.service;
 
//import eu.kielczewski.example.domain.User;
//import eu.kielczewski.example.repository.UserRepository;
//import eu.kielczewski.example.service.exception.UserAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
 
import com.dit.report.domain.Event;
import com.dit.report.domain.Event;
import com.dit.report.domain.PackageData;
import com.dit.report.domain.PackageDataDTO;
import com.dit.report.util.DeliveryStatus;
import com.dit.report.dataModel.DeliveryData;
 
import javax.inject.Inject;
 
import java.util.ArrayList;
import java.util.Hashtable;
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
 
@Service
@Validated
public class EventServiceImpl  implements EventService {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);
    private DeliveryData deliveryData;
 
    @Inject
    public EventServiceImpl(DeliveryData deliveryData) {
        this.deliveryData = deliveryData;
    }
 
    @Override
    public void updateDeliveryData(Event event){                    
                if(event.isNewPackage()){
                               PackageData pData = new PackageData(event.getName(), event.getUuid());
                               pData.setDestinationLat(event.getLat());
                               pData.setDestinationLon(event.getLon());
                               pData.setStatus(DeliveryStatus.InProgress);
                               
                               deliveryData.addData(pData);
                }else if(!event.isDelivered()) {
                               deliveryData.updateData(event);   
                } else if(event.isDelivered()) {
                               deliveryData.updateDataStatus(event);                                  
                }
    }
    @Override
    public PackageDataDTO getPackageDataDTO(String uuid){   
               PackageDataDTO pDTO = null;
              
               PackageData pData = deliveryData.getPackageDataHT().get(uuid);
               if (pData != null){
                              pDTO = new PackageDataDTO(pData);
               }
              
               return pDTO;
    }
   
    @Override
    public List<PackageDataDTO> getAllPackageDataDTO(){   
               List<PackageDataDTO> pDTOList = new ArrayList<PackageDataDTO>();
              
               Hashtable<String, PackageData> pDataHT = deliveryData.getPackageDataHT();
               Set<String> uuids = pDataHT.keySet();
               for (String uuid : uuids){
                              PackageData pData = pDataHT.get(uuid);
                              PackageDataDTO pDTO = new PackageDataDTO(pData);
                              pDTOList.add(pDTO);
               }
              
               return pDTOList;
    }
   
    @Override
    public List<Event> getGPSData(String uuid){
	   List<Event> eventList = new ArrayList<Event>();
	  
	   PackageData pData = deliveryData.getPackageDataHT().get(uuid);             
	   if (pData != null){
		   eventList = pData.getEventList();
	   }	                
	   return eventList;
    }
    
    @Override
    public Event getLatestGPSData(String uuid){
    	Event result = null;
    	
    	PackageData pData = deliveryData.getPackageDataHT().get(uuid);             
  	   	if (pData != null){
  	   		List<Event> eventList = pData.getEventList();
  	   		result = eventList.get(eventList.size()-1);
  	    }	              
  	   	
  	   	return result;
    }
}
 