package ra.presentation;

import ra.buiness.Employee;

import java.util.*;

public class EmployeeManagement {

    static List<Employee> listEmployee = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("+++++++++MENU+++++++++++");
            System.out.println("1.Nhập thông tin cho n nhân viên");
            System.out.println("2 Hiển thị thông tin nhân viên");
            System.out.println("3.Tính lương cho các nhân viên");
            System.out.println("4.Tìm kiếm nhân viên theo tên nhân viên");
            System.out.println("5.Cập nhật thông tin nhân viên");
            System.out.println("6.Xóa nhân viên theo mã nhân viên");
            System.out.println("7.Sắp xếp nhân viên theo lương tăng dần (Comparable)");
            System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)");
            System.out.println("9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choise = Integer.parseInt(scanner.nextLine());
            switch (choise) {
                case 1:
                    inputEmployee(scanner);
                    break;
                case 2:
                    displayEmployee();
                    break;
                case 3:
                    calculatedEmployee();
                    break;
                case 4:
                    searchEmployeeByName(scanner);
                    break;
                case 5:
                    updateEmployee(scanner);
                    break;
                case 6:
                    deleteEmployee(scanner);
                    break;
                case 7:
                    sortbySalary_Comparable();
                    break;
                case 8:
                    sortbyName_Comparator();
                    break;
                case 9:
                    sortByYear_Comparator();
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static void inputEmployee(Scanner scanner) {
        System.out.println("1.Nhập thông tin cho n nhân viên");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Employee employees = new Employee();
            System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1) + ":");
            employees.inputData(scanner);
            listEmployee.add(employees);
        }
    }

    public static void displayEmployee() {
        System.out.println("Danh sách thông tin nhân viên");
        for (Employee employee : listEmployee) {
            employee.displayData();

        }
    }

    public static void calculatedEmployee() {
        System.out.println("3.Tính lương cho các nhân viên");
        for (Employee employee : listEmployee) {
            employee.calSalary();
        }
        System.out.println("Đã tính lương cho các nhân viên.");

    }

    public static void searchEmployeeByName(Scanner scanner) {
        System.out.println("4.Tìm kiếm nhân viên theo tên nhân viên");
        System.out.println("Nhập tên nhân viên cần tìm");
        String searchbyName = scanner.nextLine();
        boolean search = false;
        for (Employee employee : listEmployee) {
            if (employee.getName().equalsIgnoreCase(searchbyName)) {
                employee.displayData();
                search = true;
                break;
            }
        }
        if(!search) {
            System.out.println("Không tìm thấy tên nhân viên , vui lòng nhập lại");
        }
    }
    public static void updateEmployee(Scanner scanner){
        System.out.println("5.Cập nhật thông tin nhân viên");
        System.out.println("Nhập mã nhân viên cần cập nhật");
        String searchById = scanner.nextLine();
        for (Employee employee : listEmployee) {
            if(employee.getId().equals(searchById)) {
                employee.updateDate(scanner);
                employee.calSalary();

            }
        }
        System.out.println("Cập nhật thành công");
    }
    public static void deleteEmployee(Scanner scanner){
        System.out.println("6.Xóa nhân viên theo mã nhân viên");
        System.out.println("Nhập mã nhân viên cần xóa");
        String searchById = scanner.nextLine();
        listEmployee.removeIf(employee -> employee.getId().equals(searchById));
    }
    public static void sortbySalary_Comparable() {
        System.out.println("7.Sắp xếp nhân viên theo lương tăng dần (Comparable)");
//        System.out.println(listEmployee);

        Comparator<Employee> comp = new Comparator<>(){

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() <= o2.getSalary() ? -1 : o1.getSalary() == o2.getSalary() ? 0 : 1;
            }
        };
        listEmployee.sort(comp);
//        System.out.println(listEmployee);
//        for (Employee employee : listEmployee) {
//            System.out.println("Tên " + employee.getName());
//            System.out.println("Luong" + employee.getSalary());
//
//        }
    }
    public static void sortbyName_Comparator() {
        System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)");

        Comparator<Employee> compName = new Comparator<>(){

            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };
        listEmployee.sort(compName);
    }
    public static void sortByYear_Comparator(){
        System.out.println("9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)");

        Comparator<Employee> compYear = new Comparator<>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getYear() <= o2.getYear() ? -1 : o1.getYear() == o2.getYear() ? 0 : 1;
            }
        };
        listEmployee.sort(compYear);
    }
}
//1. Nhập thông tin cho n nhân viên
//        2. Hiển thị thông tin nhân viên
//        3. Tính lương cho các nhân viên
//        4. Tìm kiếm nhân viên theo tên nhân viên
//        5. Cập nhật thông tin nhân viên
//        6. Xóa nhân viên theo mã nhân viên
//        7. Sắp xếp nhân viên theo lương tăng dần (Comparable)
//        8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)
//        9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)
//        10. Thoát
