package service;

import model.PhoneGenuine;
import repository.IPhoneRepository;
import repository.PhoneGenuineRepository;

import java.util.List;

public class PhoneGenuineService implements IPhoneService<PhoneGenuine> {
    private IPhoneRepository<PhoneGenuine> genuineRepository = new PhoneGenuineRepository();

    @Override
    public void add(PhoneGenuine entity) {
        genuineRepository.add(entity);
    }

    @Override
    public List<PhoneGenuine> getAllPhone() {
        return genuineRepository.getAllPhone();
    }

    @Override
    public void delete(PhoneGenuine entity) {
        genuineRepository.delete(entity);
    }

    @Override
    public PhoneGenuine findById(int id) {
        return genuineRepository.findById(id);
    }

    @Override
    public List<PhoneGenuine> findByName(String name) {
        return genuineRepository.findByName(name);
    }
}
