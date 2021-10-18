2021/10/17

+ ~~框架搭建~~
+ ~~数据库搭建~~
+ ~~基础页面~~
    + index.jsp
    + 404.jsp
+ ~~插入user表数据~~

+ 开发小结
    + 今天框架搭的概算顺利 就是又出现了controller 404报错 很烦啊 上次也遇到了忘记上次是怎么解决的了操

---

2021/10/18

+ ~~解决controller报错~~
+ ~~登陆页面~~
+ ~~mybatis适配~~

+ 开发小结
    + bug终于解决了 但不是我解决的 是他自己消失的
    + ~~不想用mybatis了 这么轻量级的平台 用屁mybatis~~
    + return ModelAndView 不可以用redirect哦
    + 找到问题所在了 在mapper生成错误导致一连串的报错
        + 解决方法 加载mapper映射 配置sessionFactory