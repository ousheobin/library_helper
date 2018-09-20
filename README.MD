# 云计算课程设计 - 图书馆小助手 #

**Notice: 伴随新图书馆的系统上线，查书更加方便，抓页面查询已经不可用，此项目仅供参考~**

[![Build Status](https://www.travis-ci.org/ousheobin/library_helper.svg?branch=master)](https://www.travis-ci.org/ousheobin/library_helper) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/711c6f196fd04f64be3862d91f4ad440)](https://www.codacy.com/app/ousheobin/library_helper?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ousheobin/library_helper&amp;utm_campaign=Badge_Grade)

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