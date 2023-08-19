import mysql.connector
from mysql.connector import errorcode
import datetime
from enum import Enum

class producttype(Enum):
    food = 1
    drinks =2

class products():
    def __init__(self,name,price,ptype):
        self.name=name
        self.price=price
        self.ptype = producttype(ptype).name
        self.date = datetime.datetime.now().strftime("%c")
    

product =[]
def addproduct(name,price,ptype):
    p1= products(name,price,ptype)
    product.append(p1)
    sql = "INSERT INTO products (name, price,type, datetime) VALUES (%s, %s, %s,%s)"
    val = (p1.name,str(p1.price),p1.ptype,p1.date)
    mydb = mysql.connector.connect(user='root',password='namhoa652004',host = '127.0.0.1' ,database='pythonbe')
    mycursor = mydb.cursor()
    mycursor.execute(sql,val)
    mydb.commit()

    
def delete(name):
    mydb = mysql.connector.connect(user='root',password='namhoa652004',host = '127.0.0.1' ,database='pythonbe')
    mycursor = mydb.cursor()
    sql = "DELETE FROM products WHERE name = %s"
    adr = (name,)
    mycursor.execute(sql,adr)
    mydb.commit()


def countelement():
    mydb = mysql.connector.connect(user='root',password='namhoa652004',host = '127.0.0.1' ,database='pythonbe')
    mycursor = mydb.cursor()
    mycursor.execute("SELECT * FROM products")
    myresult = mycursor.fetchall()
    count=0
    for x in myresult:
        count+=1
    print(count,"records")

def returnall():
    mydb = mysql.connector.connect(user='root',password='namhoa652004',host = '127.0.0.1' ,database='pythonbe')
    mycursor = mydb.cursor()
    mycursor.execute("SELECT * FROM products")
    myresult = mycursor.fetchall()
    for x in myresult:
        print(x)

def search(name):
    mydb = mysql.connector.connect(user='root',password='namhoa652004',host = '127.0.0.1' ,database='pythonbe')
    mycursor = mydb.cursor()
    mycursor.execute("SELECT * FROM products")
    myresult = mycursor.fetchall()
    for x in myresult:
        if (name.upper() in x[0].upper()):
            print(x)
        
try:
  cnx = mysql.connector.connect(user='root',password='namhoa652004',host = '127.0.0.1' ,database='pythonbe')
except mysql.connector.Error as err:
  if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
    print("Wrong username or password")
  elif err.errno == errorcode.ER_BAD_DB_ERROR:
    print("Database does not exist")
  else:
    print(err)
else:
    print("successfully connected")
    mycursor = cnx.cursor()
    #mycursor.execute("CREATE TABLE products (name varchar(255), price int, type varchar(255), datetime varchar(255));")

    #addproduct("Hamburger", 10000,1)
    #delete("Hamburger")

    countelement()
    returnall()
    search("coca")
    cnx.close()
