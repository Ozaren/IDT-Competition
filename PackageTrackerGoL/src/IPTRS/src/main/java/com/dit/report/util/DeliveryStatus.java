package com.dit.report.util;
 
public enum DeliveryStatus {
               InProgress ("In Progress"),
               Delivered ("Delivered");
              
               private String description;
              
               private DeliveryStatus(String description) {
                              this.description = description;
               }
              
               public String getDescription(){
                              return this.description;
               }
}