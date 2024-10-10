package service;

import model.PhoneCellular;
import repository.IPhoneRepository;
import repository.PhoneCellularRepository;

import java.util.List;

public class PhoneCellularService implements IPhoneService<PhoneCellular> {
    private IPhoneRepository<PhoneCellular> cellularRepository = new PhoneCellularRepository();

    @Override
    public void add(PhoneCellular entity) {
        cellularRepository.add(entity);
    }

    @Override
    public List<PhoneCellular> getAllPhone() {
        return cellularRepository.getAllPhone();
    }

    @Override
    public void delete(PhoneCellular entity) {
        cellularRepository.delete(entity);
    }

    @Override
    public PhoneCellular findById(int id) {
        return cellularRepository.findById(id);
    }

    @Override
    public List<PhoneCellular> findByName(String name) {
        return cellularRepository.findByName(name);
    }
}
