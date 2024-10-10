package controller;

import model.PhoneGenuine;
import service.IPhoneService;
import service.PhoneGenuineService;

import java.util.List;

public class PhoneGenuineController {
    private IPhoneService<PhoneGenuine> genuineService = new PhoneGenuineService();

    public void add(PhoneGenuine entity) {
        genuineService.add(entity);
    }

    public List<PhoneGenuine> getAllPhone() {
        return genuineService.getAllPhone();
    }

    public void delete(PhoneGenuine entity) {
        genuineService.delete(entity);
    }

    public PhoneGenuine findById(int id) {
        return genuineService.findById(id);
    }

    public List<PhoneGenuine> findByName(String name) {
        return genuineService.findByName(name);
    }
}
