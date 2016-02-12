package com.dit.report.service;
 
 
import java.util.List;
 
import com.dit.report.domain.Event;
import com.dit.report.domain.PackageDataDTO;
 
public interface EventService {
    void updateDeliveryData(Event event);
    PackageDataDTO getPackageDataDTO(String uuid);
    List<PackageDataDTO> getAllPackageDataDTO();
    List<Event> getGPSData(String uuid);
    Event getLatestGPSData(String uuid);
}