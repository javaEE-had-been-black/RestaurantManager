# User：【输入身份证/密码登陆】

Identity身份证号----唯一标识符

mobile手机号

username

sex

password

name姓名

position职位

personnel人事管理权限

statistics报表统计权限

warehouse仓库管理权限

supplier供应商管理权限

customer顾客管理

seat座位管理



admin超级管理员

 

 

# seat：座位

number座位号

type型号【人数】

comment备注

state状态：空余/未结账/已结账

 

 

# dish菜谱：

id唯一标识符

name

price价格

image图片

type种类【汤类/炒菜/酒水/其他】

 

 

# customer：会员管理

mobile手机号

name姓名

score积分

 

 

# order：订单

id唯一标识符

seat桌号

time时间

number人数

price 总价

comment备注

operatorId操作员

 

 

# orderMenu：订单和菜谱之间的关系【多对多】

orderId dishId 

count 

comment备注

 

 

# stock：进货信息

name商品名称

number数量

operatorId操作员

supplierName供货商

orderNumber订单编号

payed是否付款

price单价

allPrice总价

time进货时间

comment备注

 

 

# supplier：供货商

 name

address

mobile1

mobile2

comment

vendor联系人

mainProduct主要产品

 

 

# wareHouse：仓库管理

supplierName供货商

name商品名称

number数量

 

 

# overdue：过期的

supplierName供货商

name商品名称

number数量

operatorId操作员

time操作时间

 

 