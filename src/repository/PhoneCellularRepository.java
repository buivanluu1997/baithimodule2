package repository;

import model.PhoneCellular;
import util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class PhoneCellularRepository implements IPhoneRepository<PhoneCellular> {
    private final String FILE_CELLULAR = "src/data/phone_cellular.csv";
    @Override
    public void add(PhoneCellular entity) {
        List<PhoneCellular> phoneCellularList = getAllPhone();
        phoneCellularList.add(entity);

        writeFile(phoneCellularList);
    }

    @Override
    public void writeFile(List<PhoneCellular> list) {
        List<String> stringList = new ArrayList<>();
        for (PhoneCellular cellular : list) {
            stringList.add(cellular.csvPhoneCellular());
        }

        ReadWriteFile.writeFile(FILE_CELLULAR, stringList, false);
    }

    @Override
    public List<PhoneCellular> getAllPhone() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CELLULAR);
        List<PhoneCellular> phoneCellularList = new ArrayList<>();
        for (String cellular : stringList) {
            String[] split = cellular.split(",");
            int id = Integer.parseInt(split[0]);
            String name = split[1];
            double price = Double.parseDouble(split[2]);
            int quantity = Integer.parseInt(split[3]);
            String manufacturer = split[4];
            String country = split[5];
            String status = split[6];

            PhoneCellular phoneCellular = new PhoneCellular(id, name, price, quantity, manufacturer, country, status);
            phoneCellularList.add(phoneCellular);
        }
        return phoneCellularList;
    }

    @Override
    public void delete(PhoneCellular object) {
        List<PhoneCellular> phoneCellularList = getAllPhone();
        for (PhoneCellular phoneCellular : phoneCellularList) {
            if (phoneCellular.getId() == object.getId()) {
                phoneCellularList.remove(phoneCellular);
                break;
            }
        }
        writeFile(phoneCellularList);
    }

    @Override
    public PhoneCellular findById(int id) {
        List<PhoneCellular> phoneCellularList = getAllPhone();
        for (PhoneCellular phoneCellular : phoneCellularList) {
            if (phoneCellular.getId() == id) {
                return phoneCellular;
            }
        }
        return null;
    }

    @Override
    public List<PhoneCellular> findByName(String name) {
        List<PhoneCellular> phoneCellularList = getAllPhone();
        List<PhoneCellular> result = new ArrayList<>();
        for (PhoneCellular phoneCellular : phoneCellularList) {
            if (phoneCellular.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(phoneCellular);
            }
        }
        return result;
    }
}
