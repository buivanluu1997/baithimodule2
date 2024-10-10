package controller;

import model.PhoneCellular;
import service.IPhoneService;
import service.PhoneCellularService;

import java.util.List;

public class PhoneCellularController {
    private IPhoneService<PhoneCellular> cellularService = new PhoneCellularService();

    public void add(PhoneCellular entity) {
        cellularService.add(entity);
    }

    public List<PhoneCellular> getAllPhone() {
        return cellularService.getAllPhone();
    }

    public void delete(PhoneCellular entity) {
        cellularService.delete(entity);
    }

    public PhoneCellular findById(int id) {
        return cellularService.findById(id);
    }

    public List<PhoneCellular> findByName(String name) {
        return cellularService.findByName(name);
    }
}
