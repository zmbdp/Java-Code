package initialize;

import Information.GetConnec;
import Information.GetPassword;
import Information.GetSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesInitialize extends JFrame{
    String password = GetPassword.password;
    GetSource getSource = new GetSource();
    GetConnec getConnec = new GetConnec();

    // 创建所有表
    public TablesInitialize() throws SQLException {
        DataSource source = getSource.getDataSource();

        try (
                Connection connection = getConnec.getConnection(source);
                Statement statement = connection.createStatement()
        ) {
            String 学生表 = "create table if not exists 学生表 (" +
                    "学生id int primary key, " +
                    "学生名 varchar(20) not null, " +
                    "学生年龄 int check(学生年龄 > 0), " +
                    "学生性别 enum('男', '女')" +
                    ")";

            String 教室表 = "create table if not exists 教室表 (" +
                    "教室名 varchar(20) primary key, " +
                    "最大学生数 int check(最大学生数 > 0), " +
                    "教学楼地址 varchar(20) not null, " +
                    "教室类别 enum('普通教室', '多媒体教室', '实验室'), " +
                    "教室空闲状态 boolean default true" +
                    ")";

            String 教师表 = "create table if not exists 教师表 (" +
                    "教师id int primary key, " +
                    "教师名 varchar(20) not null," +
                    "办公室地址 varchar(20) not null," +
                    "教师性别 enum('男', '女')" +
                    ")";

            String 检查员表 = "create table if not exists 检查员表 (" +
                    "检查员id int primary key, " +
                    "检查员姓名 varchar(20) not null, " +
                    "检查员年龄 int check (检查员年龄 > 0), " +
                    "检查员性别 enum('男', '女'), " +
                    "检查员空闲状态 boolean default true" +
                    ")";

            String 设备表 = "create table if not exists 设备表 (" +
                    "设备id int primary key, " +
                    "教室名 varchar(20) not null, " +
                    "设备名称 varchar(20) not null, " +
                    "设备类型 enum('电子设备', '木制设备', '铁制设备', '其他类型'), " +
                    "使用记录 varchar(20), " +
                    "foreign key (教室名) references 教室表(教室名)" +
                    ")";

            String 检查表 = "create table if not exists 检查表 (" +
                    "设备id int, " +
                    "检查员id int, " +
                    "检查时间 date, " +
                    "设备状态 boolean default true, " +
                    "primary key(设备id, 检查员id, 检查时间), " +
                    "foreign key (设备id) references 设备表(设备id), " +
                    "foreign key (检查员id) references 检查员表(检查员id)" +
                    ")";

            String 课程表 = "create table if not exists 课程表 (" +
                    "课程id int primary key, " +
                    "教室名 varchar(20), " +
                    "教师id int, " +
                    "学生id int, " +
                    "课程名 varchar(20) not null, " +
                    "上课时间 datetime, " +
                    "下课时间 datetime, " +
                    "foreign key (教室名) references 教室表(教室名), " +
                    "foreign key (教师id) references 教师表(教师id), " +
                    "foreign key (学生id) references 学生表(学生id)" +
                    ")";

            String deleteView = "drop view if exists 学生课程表";
            PreparedStatement dropStatement = connection.prepareStatement(deleteView);
            dropStatement.executeUpdate();
            dropStatement.close();

            // 创建新的视图
            String 学生课程表 = "create view 学生课程表 as " +
                    "select 学生id, " +
                    "课程名, " +
                    "课程id, " +
                    "教室名, " +
                    "教师名, " +
                    "课程表.教师id, " +
                    "上课时间, " +
                    "下课时间 " +
                    "from 课程表 join 教师表 on 课程表.教师id = 教师表.教师id";
            

            // 创建表的顺序有讲究，必须先创建被引用的表
            String[] statementList = {学生表, 教室表, 教师表, 检查员表, 设备表, 检查表, 课程表, 学生课程表};

            // 依次执行每条SQL语句
            for (String sql : statementList) {
                statement.executeUpdate(sql);
            }
            JOptionPane.showMessageDialog(null, "初始化完成: " + " 表创建成功！");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "表创建失败：" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }
}
