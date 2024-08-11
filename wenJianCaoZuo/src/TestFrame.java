import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame {
    private static JPanel getjPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel departmentLabel = new JLabel("院系：");
        JTextField departmentField = new JTextField(20); // 宽度为20个字符长度

        JButton submitButton = new JButton("提交");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String departmentName = departmentField.getText();
                // 在这里处理提交事件，例如打印输入的内容或进一步的处理逻辑
                JOptionPane.showMessageDialog(null, "您输入的院系名为: " + departmentName);
            }
        });

        inputPanel.add(departmentLabel);
        inputPanel.add(departmentField);
        inputPanel.add(submitButton);
        return inputPanel;
    }

    public TestFrame() {
        // 设置窗口标题和关闭操作
        setTitle("测试框架");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建布局管理器
        setLayout(new BorderLayout());

        // 设置窗口的首选项大小为300x300
        Dimension size = new Dimension(400, 200);
        setPreferredSize(size);
        setSize(size); // 如果不使用布局管理器，这样设置可以保证窗口大小


        // 创建院系名输入区域：标签、文本框和按钮
        final JPanel inputPanel = getjPanel();


        // 添加到主窗体中并设置位置在中心偏下位置（South）
         add(inputPanel, BorderLayout.CENTER);

         // 设置大小和可见性，并使居中显示

        setSize(new Dimension (300, 100)); // 可以调整窗口大小以适应内容需要
        pack(); // 自动调整大小以适应其子组件的首选尺寸
        setLocationRelativeTo(null); // 居中显示

    }

    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {  /*确保GUI更新在EDT线程上执行*/
            TestFrame frame = new TestFrame();
            frame.setVisible(true);
        });
    }
}
