# User【输入身份证/密码登陆】:

userId身份证号----唯一标识符

telNumber手机号

userName

password

position职位【老板、经理、管理员】
 
# Seat座位:

seatId座位号

capacity人数

state状态【空、预留、未完成、外卖】

# Menu菜谱：

dishId唯一标识符

dishName

dishPrice价格

imageUrl

type种类【汤类/炒菜/酒水/其他】

quantity剩余数量

# Customer管理:

customerId

telNumber

customerName姓名

score积分

# Order订单:

orderId唯一标识符

seatId桌号【外键】

userId【外键】

startTime开始时间

endTime结束时间

orderPrice 总价

comment备注

userId操作员

discount

# Dish_in_Order订单和菜谱之间的关系【多对多】:

orderId

dishId 






 
