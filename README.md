# spring-boot

# 运行项目
运行src/main/java/com/HK1App.java

# vue调用mysql服务器上Detect_4数据库中event_01、event_02数据表和example3数据库中weibo1，weibo2数据表一共4个表格的前20行数据
created() {
    this.fetchData();
    axios.get("http://localhost:8383/getData?n=20").then(function (resp) {
      console.log(resp);
    });
  },
