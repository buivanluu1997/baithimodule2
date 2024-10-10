package view;

import controller.PhoneGenuineController;
import model.PhoneCellular;
import model.PhoneGenuine;
import repository.PhoneCellularRepository;

import java.util.List;
import java.util.Scanner;

public class PhoneView {
    private PhoneGenuineController phoneGenuineController = new PhoneGenuineController();
    private PhoneCellularRepository phoneCellularRepository = new PhoneCellularRepository();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ ĐIỆN THOẠI \n" +
                    "Chọn chức năng: \n" +
                    "1. Thêm mới \n" +
                    "2. Xoá \n" +
                    "3. Xem danh sách điện thoại \n" +
                    "4. Tìm kiếm \n" +
                    "5. Thoát");
            try {
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("-------------------------------Thêm mới-------------------------------");
                        addPhone();
                        break;
                    case 2:
                        System.out.println("-------------------------------Xoá-------------------------------");
                        deletePhone();
                        break;
                    case 3:
                        System.out.println("-------------------------------Xem danh sách điện thoại-------------------------------");
                        showPhone();
                        break;
                    case 4:
                        System.out.println("-------------------------------Tìm theo tên điện thoại-------------------------------");
                        System.out.println("Nhập tên điện thoại muốn tìm kiếm: ");
                        String name = scanner.nextLine();
                        List<PhoneGenuine> phoneGenuineList = phoneGenuineController.findByName(name);
                        List<PhoneCellular> phoneCellularList = phoneCellularRepository.findByName(name);
                        if (phoneGenuineList.isEmpty() && phoneCellularList.isEmpty()) {
                            System.out.println("Tên khách hàng không có trong danh sách");
                        } else {
                            if (!phoneGenuineList.isEmpty()) {
                                for (PhoneGenuine phone : phoneGenuineList) {
                                    System.out.println(phone.displayInfo());
                                }
                            }
                            if (!phoneCellularList.isEmpty()) {
                                for (PhoneCellular phone : phoneCellularList) {
                                    System.out.println(phone.displayInfo());
                                }
                            }
                        }
                        break;
                    case 5:
                        System.out.println("-------------------------------Thoát-------------------------------");
                        System.exit(0);

                }
            }catch (NumberFormatException e) {
                System.out.println("Lỗi: Nhập vào không phải là số nguyên");
            }

        }
    }

    private void showPhone() {
        System.out.println("---------------Điện thoại chính hãng---------------");
        List<PhoneGenuine> phoneGenuineList = phoneGenuineController.getAllPhone();
        for (PhoneGenuine phone : phoneGenuineList) {
            System.out.println(phone.displayInfo());
        }
        System.out.println("---------------Điện thoại xách tay---------------");
        List<PhoneCellular> phoneCellularList = phoneCellularRepository.getAllPhone();
        for (PhoneCellular phone : phoneCellularList) {
            System.out.println(phone.displayInfo());
        }
    }

    private void deletePhone() {
        System.out.println("Chọn loại điện thoại muốn xoá: \n" +
                "1. Điện thoại chính hãng \n" +
                "2. Điện thoại xách tay");
        int choose2 = Integer.parseInt(scanner.nextLine());
        switch (choose2) {
            case 1:
                System.out.println("Nhậi id muốn xoá");
                int id = Integer.parseInt(scanner.nextLine());
                PhoneGenuine phoneGenuine = phoneGenuineController.findById(id);
                if (phoneGenuine != null) {
                    phoneGenuineController.delete(phoneGenuine);
                    System.out.println("Đã xoá thành công");
                } else {
                    System.out.println("Điện thoại không tồn tại");
                }
                break;
            case 2:
                System.out.println("Nhập id muốn xoá:");
                int id2 = Integer.parseInt(scanner.nextLine());
                PhoneCellular phoneCellular = phoneCellularRepository.findById(id2);
                if (phoneCellular != null) {
                    phoneCellularRepository.delete(phoneCellular);
                    System.out.println("Đã xoá thành công");
                }else {
                    System.out.println("Điện thoại không tồn tại");
                }
            default:
                System.out.println("Chọn ngoài 1 và 2 nên thoát");
                break;
        }
    }

    private void addPhone() {
        System.out.println("Chọn loại điện thoại để thêm mới: \n" +
                "1. Điện thoại chính hãng \n" +
                "2. Điện thoại xách tay");
        int choose2 = Integer.parseInt(scanner.nextLine());
        switch (choose2) {
            case 1:
                addPhoneGenuine();
                break;
            case 2:
                addPhoneCellular();
                break;
        }
    }

    private void addPhoneCellular() {
        System.out.println("Nhập id điện thoại:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên điện thoại:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá bán điện thoại:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất:");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhập quốc gia xách tay (ngoại trừ việt nam)");
        String country = scanner.nextLine();
        System.out.println("Chọn trạng thái sửa chữa: \n" +
                "1. Đã sửa chữa \n" +
                "2. Chưa sửa chữa");
        int choose3 = Integer.parseInt(scanner.nextLine());
        String status = "";
        switch (choose3) {
            case 1:
                status = "Đã sửa chữa";
                break;
            case 2:
                status = "Chưa sửa chữa";
                break;
            default:
                System.out.println("Chọn ngoài 1 và 2 nên thoát");
        }

        PhoneCellular phoneCellular = new PhoneCellular(id, name, price, quantity, manufacturer, country, status );
        phoneCellularRepository.add(phoneCellular);
        System.out.println("Đã thêm sản phẩm thành công");
    }

    private void addPhoneGenuine() {
        System.out.println("Nhập id điện thoại:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên điện thoại:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá bán điện thoại:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất:");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhập thời gian bảo hành:");
        int warrantyPeriod = Integer.parseInt(scanner.nextLine());
        System.out.println("Chọn phạm vi bảo hành: \n" +
                "1. Toàn quốc \n" +
                "2. Quốc tế");
        int choose3 = Integer.parseInt(scanner.nextLine());
        String warrantyScope = "";
        switch (choose3) {
            case 1:
                warrantyScope = "Toàn quốc";
                break;
            case 2:
                warrantyScope = "Quốc tế";
                break;
            default:
                System.out.println("Chọn ngoài 1 và 2 nên thoát");
                break;
        }

        PhoneGenuine phoneGenuine = new PhoneGenuine(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope);
        phoneGenuineController.add(phoneGenuine);
        System.out.println("Đã thêm sản phẩm thành công");
    }
}
