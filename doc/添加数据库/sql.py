from datetime import datetime
import xlrd
import pymysql
import re



def excel2str(item):
    return re.findall(r':.*', str(item))[0][1:]


def insert(filename, db_user, db_password, db_name):
    db = pymysql.connect("localhost", db_user, db_password, db_name)
    cursor = db.cursor()
    tb = xlrd.open_workbook(filename)
    execute(db, cursor, tb, "bill")
    execute(db, cursor, tb, "seat")
    execute(db, cursor, tb, "customer")
    execute(db, cursor, tb, "dish")
    execute(db, cursor, tb, "repository")
    execute(db, cursor, tb, "order")
    execute(db, cursor, tb, "user")
    db.close()


def execute(db, cursor, tb, sh_name):
    sh = tb.sheet_by_name(sh_name)
    parm = sh.row(0)
    n = sh.nrows
    for i in range(1, n):
        row = sh.row(i)
        sql = "INSERT INTO restaurant_" + sh_name + "("
        p = ""
        for i in parm:
            p += excel2str(i)[1:-1]
            p += ","
        sql += p[:-1] + ") VALUES ("
        p = ""
        for i in row:
            if i.ctype == 3:
                p += "'" + str(datetime.now().strftime('%Y-%m-%d %H:%M:%S')) + "'"
                p += ","
                continue
            elif i.ctype==2 and i.value%1==0.0:
                value=int(i.value)
                p+=str(value)
                p+=","
                continue
            p += excel2str(i)
            p += ","
        sql += p[:-1] + ")"
        print(sql)
        try:
            cursor.execute(sql)
            db.commit()
            print("success")
        except:
            print(db.rollback())


insert("example.xlsx", "root", "123456", "order")
