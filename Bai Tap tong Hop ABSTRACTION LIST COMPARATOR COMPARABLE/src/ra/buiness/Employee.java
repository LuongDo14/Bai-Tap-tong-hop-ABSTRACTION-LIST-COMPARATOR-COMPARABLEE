package ra.buiness;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String Id;
    private String Name;
    private int Year;
    private float Rate;
    private float Commission;
    private float Salary;
    private boolean Status;

    public Employee() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public float getCommission() {
        return Commission;
    }

    public void setCommission(float commission) {
        Commission = commission;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        Id = id;
        Name = name;
        Year = year;
        Rate = rate;
        Commission = commission;
        Salary = salary;
        Status = status;

    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã nhân viên");
        this.Id = scanner.nextLine();
        System.out.println("Nhập tên nhân viên");
        this.Name = scanner.nextLine();
        System.out.println("Nhập năm sinh nhân viên");
        this.Year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập hệ số lương nhân viên");
        this.Rate = Float.parseFloat(scanner.nextLine());
        System.out.println("Hoa hồng của nhân viên hàng tháng");
        this.Commission = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái nhân viên");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.Status = Boolean.parseBoolean(status);
                break;
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        } while (true);
    }
    public void calSalary(){
        this.Salary = Rate * BASIC_SALARY + Commission;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã : %s - Tên : %s - Năm sinh : %d - Hệ số lương : %f - Hoa hồng hàng tháng : %f - Lương hàng tháng : %f - Trạng thái : %s\n" ,
                this.Id,this.Name,this.Year,this.Rate,this.Commission,this.Salary,
                this.isStatus() ? "Đang làm việc" : "Nghỉ việc");
    }
    public void updateDate(Scanner scanner) {
        System.out.println("Nhập mã nhân viên");
        this.Id = scanner.nextLine();
        System.out.println("Nhập tên nhân viên");
        this.Name = scanner.nextLine();
        System.out.println("Nhập năm sinh nhân viên");
        this.Year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập hệ số lương nhân viên");
        this.Rate = Float.parseFloat(scanner.nextLine());
        System.out.println("Hoa hồng của nhân viên hàng tháng");
        this.Commission = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái nhân viên");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.Status = Boolean.parseBoolean(status);
                break;
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        } while (true);
    }
}
