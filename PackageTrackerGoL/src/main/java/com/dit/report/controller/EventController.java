package com.dit.report.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
 
import com.dit.report.domain.Event;
import com.dit.report.domain.PackageData;
import com.dit.report.domain.PackageDataDTO;
import com.dit.report.service.EventService;
import com.dit.report.util.EventFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
 
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
 
import java.io.PrintWriter;
import java.util.List;
 
@RestController
public class EventController {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final EventService eventService;
 
    @Inject
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
 
    @RequestMapping(value="/tracknewpackage", method=RequestMethod.GET)
    @ResponseBody
    public void trackNewPackage(@RequestParam("name") String name,
                              @RequestParam("destinationLat") Float destinationLat,
                              @RequestParam("destinationLon") Float destinationLon,
                              @RequestParam("uuid") String uuid,
                              HttpServletResponse response) {
              
               LOGGER.debug("Received request to create track new package: " + uuid);
              
               Event event = new Event();
               event.setName(name);
               event.setLat(destinationLat);
               event.setLon(destinationLon);
               event.setUuid(uuid);
               eventService.updateDeliveryData(event);
              
               try{
                              response.setContentType("application/json");
                              PrintWriter writer = response.getWriter();
                              writer.print("{ \"ackUUID\":\""+uuid+"\"}");
                              writer.flush();
               }catch (Exception ex) {
                              ex.printStackTrace();
               }
    }
 
   
    @RequestMapping(value = "/packagetrackupdate/{uuid}", method = RequestMethod.POST)
    public void updatePackage(@PathVariable("uuid") String uuid, @RequestBody Event event) {
               // LOGGER.debug("Received request to create the {}", event);
              
               event.setUuid(uuid);
               eventService.updateDeliveryData(event);      
        
        if (event.isDelivered())
               LOGGER.debug("package uuid: " + event.getUuid() + " delivered.");
    }
   
    @RequestMapping(value = "/getPackageData/{uuid}", method = RequestMethod.GET)
    public PackageDataDTO getPackageDataDTO(@PathVariable("uuid") String uuid) {
               //LOGGER.debug("$$$$$$$$$ get packageDataDTO: " + uuid);
               return eventService.getPackageDataDTO(uuid);
    }
   
    @RequestMapping(value = "/getAllPackageData", method = RequestMethod.GET)
    public List<PackageDataDTO> getAllPackageDataDTO() {         	
               return eventService.getAllPackageDataDTO();
    }
   
    //http://www.javavillage.in/REST-best-example-with-spring-boot.php
    @RequestMapping(value = "/getGPSData/{uuid}", method = RequestMethod.GET)
    public String getGPSData(@PathVariable("uuid") String uuid) {   
               //return eventService.getGPSData(uuid);
              
               ObjectMapper mapper = new ObjectMapper();
                   SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("name", "uuid", "ele", "time", "delivered", "newPackage");
                   FilterProvider filters = new SimpleFilterProvider().addFilter("eventFilter", theFilter);
              
                   String json = null;
                   try{
                              json = mapper.writer(filters).writeValueAsString(eventService.getGPSData(uuid));
                   }catch (Exception ex){
                              ex.printStackTrace();
                   }
              
                   return json;                        
              
    }
   
    @RequestMapping(value = "/getLatestGPSData/{uuid}", method = RequestMethod.GET)
    public String getLatestGPSData(@PathVariable("uuid") String uuid) {                         
       ObjectMapper mapper = new ObjectMapper();
           SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("name", "uuid", "ele", "time", "delivered", "newPackage");
           FilterProvider filters = new SimpleFilterProvider().addFilter("eventFilter", theFilter);
      
           String json = null;
           try{
        	   json = mapper.writer(filters).writeValueAsString(eventService.getLatestGPSData(uuid));
           }catch (Exception ex){
        	   ex.printStackTrace();
           }
      
           return json;                        
              
    }
 
}