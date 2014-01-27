/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hotelverwaltung;

import com.mycompany.hotelverwaltung.exceptions.ServiceAlreadyExistsException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

/**
 *
 * @author said
 */

public class Services {


    private List<String> namesOfServices;
    
    
    private Map<String,Service> services;
    
    
    public Services(List<String> nameOfService, Map<String, Service> services){
        this.namesOfServices=nameOfService;
        this.services=services;
    }

    public void addService(Service s) throws ServiceAlreadyExistsException{
        if (namesOfServices.contains(s.getName())){
            throw new ServiceAlreadyExistsException();
        }
        namesOfServices.add(s.getName());
        services.put(s.getName(), s);
    }
    public void removeService(Service s){
        namesOfServices.remove(s.getName());
        services.remove(s.getName());
    }
    public List<String> getNameOfService() {
        return namesOfServices;
    }

    public void setNameOfService(ArrayList<String> nameOfService) {
        this.namesOfServices = nameOfService;
    }

    public Map<String, Service> getServices() {
        return services;
    }

    public void setServices(HashMap<String, Service> services) {
        this.services = services;
    }
    

    
}
