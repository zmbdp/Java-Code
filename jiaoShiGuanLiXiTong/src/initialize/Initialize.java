package initialize;


import java.sql.SQLException;

public class Initialize {
    public Initialize() throws SQLException {
        // 创建表
        new TablesInitialize();
        // 初始化教室表
        new ClassInitialize();
        // 初始化教师表
        new TeacherInitialize();
        // 初始化学生表
        new StudentInitialize();
        // 初始化检查员表
        new CensorInitialize();
        // 得先初始化设备表
        new equipmentInitialize();
        // 检查表
        new InspectionInitialize();
        // 课程表
        new CourseInitialize();
    }
}
