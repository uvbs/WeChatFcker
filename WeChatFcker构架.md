### WeChatFcker构架


#### 植入
| 伪装正常应用<br>
应用启动时在后台注册服务。<br>
| 请求相应权限<br>
普通权限：监听开机广播；<br>
运行时权限：读取通讯录、读取短信、读取相册；<br>
#### 自启&保活
| 自启：<br>
<Br>
| 保活：<br>
1像素保活；<br>
服务自重启；<br>
#### 客户端活动
| 监控微信UI界面<br>
| 获取通讯录联系人信息<br>
| 获取短信列表<br>
| 获取图库<br>
| 数据库存储<br>
| 消息嵌入<br>
| 微信发送指定信息<br>
<------------------------------------------------------->
#### 服务器活动
| 捕获信息<br>
| 信息提取<br>
<------------------------------------------------------->
#### 算法
| 信息嵌入与提取<br>
LSB;<br>