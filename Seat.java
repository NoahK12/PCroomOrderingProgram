package PCroomOrderingSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Seat extends JFrame {
	public static int seatNumber;
	private JPanel contentPane;

	public int getSeatNumber() {
		return seatNumber;
	}
	
	//Seat frame 생성
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat frame = new Seat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Seat frame 구성
	public Seat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 25);
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		
		//1번 좌석 버튼 (이하 버튼 동일)
		JButton seatNumber1 = new JButton("1번 좌석");
		seatNumber1.setFont(font);
		seatNumber1.setBounds(28, 64, 97, 23);
		seatNumber1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				seatNumber = 1;
				//MainFrame 클래스로 넘어감
				new MainFrame();
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(seatNumber1);

		JButton seatNumber2 = new JButton("2번 좌석");
		seatNumber2.setFont(font);
		seatNumber2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seatNumber = 2;
				new MainFrame();
				setVisible(false);
			}
		});
		seatNumber2.setBounds(168, 64, 97, 23);
		contentPane.add(seatNumber2);

		JButton seatNumber3 = new JButton("3번 좌석");
		seatNumber3.setFont(font);
		seatNumber3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seatNumber = 3;
				new MainFrame();
				setVisible(false);
			}
		});
		seatNumber3.setBounds(302, 64, 97, 23);
		contentPane.add(seatNumber3);

		JButton seatNumber4 = new JButton("4번 좌석");
		seatNumber4.setFont(font);
		seatNumber4.setBounds(28, 136, 97, 23);
		seatNumber4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seatNumber = 4;
				new MainFrame();
				setVisible(false);
			}
		});
		contentPane.add(seatNumber4);

		JButton seatNumber5 = new JButton("5번 좌석");
		seatNumber5.setFont(font);
		seatNumber5.setBounds(168, 136, 97, 23);
		seatNumber5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seatNumber = 5;
				new MainFrame();
				setVisible(false);
			}
		});
		contentPane.add(seatNumber5);

		JButton seatNumber6 = new JButton("6번 좌석");
		seatNumber6.setFont(font);
		seatNumber6.setBounds(302, 136, 97, 23);
		seatNumber6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seatNumber = 6;
				new MainFrame();
				setVisible(false);
			}
		});
		contentPane.add(seatNumber6);

		JButton seatNumber7 = new JButton("7번 좌석");
		seatNumber7.setFont(font);
		seatNumber7.setBounds(28, 209, 97, 23);
		seatNumber7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seatNumber = 7;
				new MainFrame();
				setVisible(false);
			}
		});
		contentPane.add(seatNumber7);

		JButton seatNumber8 = new JButton("8번 좌석");
		seatNumber8.setFont(font);
		seatNumber8.setBounds(168, 209, 97, 23);
		seatNumber8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seatNumber = 8;
				new MainFrame();
				setVisible(false);
			}
		});
		contentPane.add(seatNumber8);

		JButton seatNumber9 = new JButton("9번 좌석");
		seatNumber9.setFont(font);
		seatNumber9.setBounds(302, 209, 97, 23);
		seatNumber9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				seatNumber = 9;
				new MainFrame();
				setVisible(false);
			}
		});
		contentPane.add(seatNumber9);
		
		//로고 라벨
		JLabel lblNewLabel = new JLabel("Goot PC방");
		lblNewLabel.setFont(font1);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(160, 10, 150, 29);
		contentPane.add(lblNewLabel);

		// 배경화면 이미지
		String imgPath = "src/PCroomOrderingSystem/seatimage.jpg";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changeImg = originImg.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changeImg);
		JLabel background = new JLabel(Icon);
		background.setBounds(0, 0, 500, 300);
		contentPane.add(background);
	}
}