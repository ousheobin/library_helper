# 云计算课程设计 - 图书馆小助手 #

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/43a4f01ab8164a81b267b33d5a6f0ef1)](https://app.codacy.com/app/ousheobin/library_helper?utm_source=github.com&utm_medium=referral&utm_content=ousheobin/library_helper&utm_campaign=Badge_Grade_Dashboard)

**Notice: 伴随新图书馆的系统上线，查书更加方便，抓页面查询已经不可用，此项目仅供参考~**

## 作者 ##

- Shaobin.Ou
- Jinbiao.Cai
- Jiada.Zeng
- Qian.Chen
- Yongwei.Zhang
- Jianjun.Huang

## 配置说明 ##

本系统需搭配[智慧华广云平台](http://weibo.gcu.edu.cn)的sso和公共号消息推送功能使用

- 数据库配置在 config/config.properties
- 轻应用配置在 com.tentcoo.platform.TokenManager.TokenManager
- 推送配置在 com.tentcoo.message.WrapMessage
- 建表语句在 sql/Create Table.sql
- 定时器在 com.tentcoo.schedule.PushMessageTask

## 托管镜像 ##

[github](https://github.com/ousheobin/library_helper)

[git@osc](https://gitee.com/ousheobun/library_helper)