package stud;
import java.util.Scanner;
class Rectangle
{
	private int width,length;
	private String name;
	public void setRectangle(int a, int b,String c) 
	{
		this.width=a;
		this.length=b;
		this.name =c;
	}
	public String getRectangle() 
	{
		return name;
	}
	public void chuvi() 
	{
		System.out.println((width+length)*2);
	}
	public void size() 
	{
		System.out.println(width*length);
	}
}


class Main {
public static void main(String[] args) {
	int a,b;
	String name;
	Scanner myobj = new Scanner(System.in);
	name = myobj.nextLine();
	a= myobj.nextInt();
	b= myobj.nextInt();
 Rectangle myrec = new Rectangle();
 myrec.setRectangle(a, b, name);
 System.out.println(myrec.getRectangle());
 myrec.chuvi();
 myrec.size();
}
}
