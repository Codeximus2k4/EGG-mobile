import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) 
	{
		int choice=0;
		ArrayList<NhanVien> listnhanvien = new ArrayList<NhanVien>();
		System.out.println("Hay dua ra lua chon");
		System.out.println("1. Them nhan vien");
		System.out.println("2. Xoa nhan su");
		System.out.println("3. List nhan su");
		System.out.println("4. List theo bang luong");
		System.out.println("5. List theo role");
		System.out.println("6. Thoat");
		Scanner scanner = new Scanner(System.in);
		while (choice!=6) 
		{
			choice = scanner.nextInt();
			if (choice==1) 
			{
				NhanVien nhanvien = new NhanVien();
				nhanvien.nhap();
				listnhanvien.add(nhanvien);
			}
			else if (choice==2) 
			{
				int idremove;
				idremove = scanner.nextInt();
				listnhanvien.remove(idremove);
			}
			else if (choice==3) 
			{
				System.out.println("ID name Age Role");
				for (int i=0;i<listnhanvien.size();i++) 
				{
					System.out.println(i+" "+listnhanvien.get(i).getName()+" "+listnhanvien.get(i).getAge()+" "+listnhanvien.get(i).getRole());
				}
			}
			else if (choice==4) 
			{
				System.out.println("ID name Salary Role");
				for (int i=0;i<listnhanvien.size();i++) 
				{
					System.out.println(i+" "+listnhanvien.get(i).getName()+" "+listnhanvien.get(i).getSalary()+" "+listnhanvien.get(i).getRole());
				}
			}
			else if (choice==5) 
			{
				System.out.println("ID name Role");
				for (int i=0;i<listnhanvien.size();i++) 
				{
					System.out.println(i+" "+listnhanvien.get(i).getName()+" "+listnhanvien.get(i).getRole());
				}
			}
		}
	}
}
