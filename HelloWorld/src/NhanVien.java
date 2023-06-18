import java.util.Scanner;
public class NhanVien 
{
	private int age,salary;
	private String name,role;
    public void setAge(int a) 
    {
    	this.age=a;
    }
    public int getAge() 
    {
    	return this.age;
    }
    public void setName(String a) 
    {
    	this.name=a;
    }
    public String getName() 
    {
    	return this.name;
    }
    public void setSalary(int a) 
    {
    	this.salary=a;
    }
    public int getSalary() 
    {
    	return this.salary;
    }
    public void setRole(String a) 
    {
    	this.role=a;
    }
    public String getRole() 
    {
    	return this.role;
    }
    public void nhap() 
    {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Hay nhap ten");
    	name = scanner.nextLine();
    	setName(name);
    	System.out.println("Hay nhap tuoi");
    	age = scanner.nextInt();
    	setAge(age);
    	System.out.println("Hay nhap luong");
    	salary = scanner.nextInt();
    	setSalary(salary);
    	role = scanner.nextLine();
    	System.out.println("Hay nhap role");
    	role = scanner.nextLine();
    	setRole(role);
    }
}
