import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class select extends JFrame implements ActionListener {
	public static String FilePath;
	private static final long serialVersionUID = 1L;

	JButton btn = null;

	JTextField textField = null;

	public select() {
		this.setTitle("选择文件窗口");
		FlowLayout layout = new FlowLayout();// 布局
		JLabel label = new JLabel("请选择文件：");// 标签
		textField = new JTextField(30);// 文本域
		btn = new JButton("浏览");// 钮1

		// 设置布局
		layout.setAlignment(FlowLayout.LEFT);// 左对齐
		this.setLayout(layout);
		this.setBounds(400, 200, 600, 70);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.addActionListener(this);
		this.add(label);
		this.add(textField);
		this.add(btn);

	}

	public static void main(String[] args) {
		new select();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.showDialog(new JLabel(), "选择");
		File file = chooser.getSelectedFile();
		textField.setText(file.getAbsoluteFile().toString());
		FilePath = file.getAbsoluteFile().toString();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui window = new ui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.dispose();
	}
}
