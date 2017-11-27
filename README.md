# monster-task\n
批量任务平台说明：\n
主要使用技术：quarts2.2.1, spring4.3.1, spring-mvc4.3.1, mybatis3.2.6\n
数据库：Mysql\n

v1.0详细说明：\n
1.MonsterLog4jUtil封装日志输出，输出格式为线程号-类-时间-信息，log4j配置控制台和文件输出，初始定义10M一个文件。\n
2.MonsterResultManager封装返回结果，用code + message + 返回内容的形式统一结果格式，以code定义业务异常。\n
3.MonsterServletUtils封装servlet输出/输出，request转业务vo对象，key值与其属性匹配，response按结果样式MonsterResultManager以json字符串流输出。\n
4.controller层进行aop，处理行为：\n
    4.1 系统流程日志输出（待实现）。\n
    4.2 后台安全检查（待实现）。\n
    4.3 用户服务访问权限检查（待实现）。\n
    4.4 系统服务监控（待实现）。\n
    4.5 业务异常透明，业务流程可直接抛出异常，基础架构统一捕获处理。\n
5.service层进行aop（待实现），处理行为：\n
    5.1 事物管理（待实现），实现可延续事物和独立事物。\n
    5.2 系统流程日志输出（待实现）。\n
6.批量任务可视化管理，支持job列表条件查询、job新增、job修改、job删除、job暂停、job立即执行、job重启和job续跑。\n

2017/09/21更新内容：\n
1.log4j配置内容更新。\n
2.service aop内容（未进行spring配置）和controller aop内容更新。\n
3.日志Util的更新。\n
4.通用常量内容。\n
