package repository;

import model.PhoneGenuine;
import util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class PhoneGenuineRepository implements IPhoneRepository<PhoneGenuine> {
    private final String FILE_GENUINE = "src/data/phone_genuine.csv";

    @Override
    public void add(PhoneGenuine entity) {
        List<PhoneGenuine> phones = getAllPhone();
        phones.add(entity);

        writeFile(phones);
    }

    @Override
    public void writeFile(List<PhoneGenuine> list) {
        List<String> stringList = new ArrayList<>();
        for (PhoneGenuine phone : list) {
            stringList.add(phone.csvPhoneGenuine());
        }
        ReadWriteFile.writeFile(FILE_GENUINE, stringList, false);
    }

    @Override
    public List<PhoneGenuine> getAllPhone() {
        List<String> stringList = ReadWriteFile.readFile(FILE_GENUINE);
        List<PhoneGenuine> list = new ArrayList<>();
        for (String phone : stringList) {
            String[] split = phone.split(",");
            int id = Integer.parseInt(split[0]);
            String name = split[1];
            double price = Double.parseDouble(split[2]);
            int quantity = Integer.parseInt(split[3]);
            String manufacturer = split[4];
            int warrantyPeriod = Integer.parseInt(split[5]);
            String warrantyScope = split[6];

            PhoneGenuine phoneGenuine = new PhoneGenuine(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope);
            list.add(phoneGenuine);
        }
        return list;
    }

    @Override
    public void delete(PhoneGenuine entity) {
        List<PhoneGenuine> phones = getAllPhone();
        for (PhoneGenuine phone : phones) {
            if (phone.getId() == entity.getId()) {
                phones.remove(phone);
                break;
            }
        }
        writeFile(phones);
    }

    @Override
    public PhoneGenuine findById(int id) {
        List<PhoneGenuine> phones = getAllPhone();
        for (PhoneGenuine phone : phones) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }

    @Override
    public List<PhoneGenuine> findByName(String name) {
        List<PhoneGenuine> phones = getAllPhone();
        List<PhoneGenuine> result = new ArrayList<>();

        for (PhoneGenuine phone : phones) {
            if (phone.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(phone);
            }
        }
        return result;
    }
}
