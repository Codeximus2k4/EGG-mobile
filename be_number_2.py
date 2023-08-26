from datetime import datetime

from sqlalchemy import create_engine
from sqlmodel import SQLModel, Field, Session, select,text,update
from enum import Enum
engine = create_engine("mysql://root:namhoa652004@localhost:3306/pythonbe1", echo=True)
#print(f'engine : {engine}')

    
class Product(SQLModel, table=True):
    __tablename__ = "products"
    id: int = Field(primary_key=True)
    name: str = Field(nullable=True)
    price: int = Field(gt=0)
    tag: str
    created_at: datetime

    # def __init__(self, name, price, tag, datetime, **data: Any):
    #     super().__init__(**data)
    #     self.name = name
    #     self.price = price
    #     self.tag = tag
    #     self.datetime = datetime
    #
    # def __str__(self):
    #     return f"Product: {self.name}, Price: ${self.price}, Tag: {self.tag}, Date: {self.datetime}"


SQLModel.metadata.create_all(engine)


def add_product(name: str,
                price: int,
                tag: str,
                created_at: datetime):
    _product = Product(
        name=name,
        price=price,
        tag=tag,
        created_at=created_at
    )
    session = Session(engine)
    session.add(_product)
    session.commit()


def remove_product(name: str):
    session = Session(engine)
    statement = select(Product).where(Product.name == name)
    results = session.exec(statement)
    _product = results.one()
    session.delete(_product)
    session.commit()


def numbers_of_product():  # output int
    session = Session(engine)
    statement = select(Product)
    results = session.exec(statement)
    number =0
    for each in results.all():
        number = number+1
    print("The number of products at the moment is :" + str(number))
    


def find_product(name: str):  # query like => output array product
    session = Session(engine)
    matching_product=[]
    statement = select(Product)
    results = session.exec(statement)
    for each in results:
        if name.upper() in each.name.upper():
            matching_product.append(each)
    print(matching_product)


def get_all_product(limit: int, offset: int, order_by: str):  # name-desc
    # order_by_demo = "name-desc"|price-desc|created_at-desc
    textual_sql = text("SELECT * FROM products ORDER BY "+ order_by)
    session = Session(engine)
    orm_sql = select(Product).from_statement(textual_sql)
    for user_obj in session.execute(orm_sql).scalars():
        print(user_obj)


def update_product(product_id: int, schema: dict):
    # schema_demo = {
    #     "name": "",
    #     "price": 100,
    #     "tag": "",
    #     "created_at" :""
    # }
    session =Session(engine)
    if schema["name"]!="":
        statement = (update(Product).where(Product.id == product_id).values(name=schema["name"]).execution_options(synchronize_session="fetch"))
        session.execute(statement)
        session.commit()
    if schema["price"]!=0:
        statement = (update(Product).where(Product.id == product_id).values(price=schema["price"]).execution_options(synchronize_session="fetch"))
        session.execute(statement)
        session.commit()

    if schema["tag"]!="":
        statement = (update(Product).where(Product.id == product_id).values(tag=schema["tag"]).execution_options(synchronize_session="fetch"))
        session.execute(statement)
        session.commit()

    if schema["created_at"]!="":
        statement = (update(Product).where(Product.id == product_id).values(created_at=schema["created_at"]).execution_options(synchronize_session="fetch"))
        session.execute(statement)
        session.commit()
        

#add_product("Vinamilk",3000,'beverage',datetime.now())
#numbers_of_product()
#find_product("me")

update_product(1,{"name":"Pork","price":5000,"tag":"","created_at":""})
get_all_product(1,5,"price")
# remove_product(name="Meat")
