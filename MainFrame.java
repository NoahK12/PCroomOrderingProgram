package PCroomOrderingSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import PCroomOrderingSystem.MemDAO;
import PCroomOrderingSystem.MemDTO;

public class MainFrame extends JFrame {
	DefaultTableModel tableModel;
	JTable table;
	int orderNumber = 0;
	int totalPrice;
	int orderQuantity;
	int seatNumber;
	String productName;

	public MainFrame() {

		String imgPath = "src\\PCroomOrderingSystem\\mainframeimage.jpg";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changeImg = originImg.getScaledInstance(730, 500, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changeImg);
		// 디자인단
		// 프레임 설정단
		setTitle("PC방 주문시스템");
		setBounds(0, 0, 730, 1000); // 프레임 위치
		setBackground(Color.RED); //

		// 폰트
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 16);

		// 상단
		Panel pNorth = new Panel();
		JLabel aa = new JLabel(Icon);
		pNorth.add(aa);
		aa.setBounds(0, 100, 730, 330);

		pNorth.setBackground(new Color(250, 250, 255));
		// setLayout을 사용하여 자동으로 생성되는 레이아웃을 변경
		pNorth.setLayout(null); 
		pNorth.setSize(0, 500);
		// 상단 폰트
		pNorth.setFont(font); 

		// 배열 설정 부분
		String menu[] = { "식사류", "냉동식품", "음료" };

		JButton category[] = new JButton[menu.length];

		for (int i = 0; i < menu.length; i++) {

			// 카테고리 버튼 위치 설정
			category[i] = new JButton(menu[i]);
			if (i < 4) {
				category[i].setBounds(90 + i * 200, 50, 130, 30);
			}

			pNorth.add(category[i]);

		}

		//식사류 선택 버튼
		category[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Noodle(MainFrame.this);
			}
		});
		
		//냉동식품 선택 버튼
		category[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Frozenfood(MainFrame.this);
			}
		});
		
		//음료 선택 버튼
		category[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Beverage(MainFrame.this);
			}
		});

		// 문의하기 버튼
		JButton ask = new JButton("문의하기");
		pNorth.add(ask);
		ask.setBounds(category[1].getX(), 450, 130, 30);
		ask.setBackground(new Color(250, 230, 200));

		ask.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ServerFrame 객체 생성
				new ServerFrame();
			}
		});

		ask.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ClientFrame 객체 생성
				new ClientFrame();
			}
		});

		// 장바구니
		String[] cols = { "상품명", "주문수량", "총 가격", "좌석번호" };
		tableModel = new DefaultTableModel(cols, 12);
		table = new JTable(tableModel);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setEnabled(false);
		// 가운데정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(font1);
		scrollPane.setBounds(30, 300, 700, 500);

		// 하단
		JPanel pSouth = new JPanel();
		pSouth.setFont(font);
		pSouth.setBackground(new Color(250, 250, 255));

		// 주문, 초기화, 닫기 버튼 생성
		JButton order = new JButton("주문");
		JButton reset = new JButton("초기화");
		JButton close = new JButton("닫기");

		order.setBounds(0, 0, 0, 0);
		reset.setBounds(100, 300, 100, 30);
		close.setBounds(500, 300, 100, 30);

		pSouth.add(order);
		pSouth.add(reset);
		pSouth.add(close);

		// 주문버튼
		order.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < orderNumber; i++) {
					for (int j = 0; j < table.getColumnCount(); j++) {
						if (j == 0) {
							productName = (String) table.getValueAt(i, j);
						} else if (j == 1) {
							orderQuantity = Integer.valueOf(table.getValueAt(i, j).toString());
						} else if (j == 2) {
							totalPrice = Integer.valueOf(table.getValueAt(i, j).toString());
						} else {
							seatNumber = Integer.valueOf(table.getValueAt(i, j).toString());
							MemDAO dao = MemDAO.getInstance();
							MemDTO dto = new MemDTO(totalPrice, orderQuantity, seatNumber, productName);
							dao.insertMethod1(dto);
						}
					}
				}
				JOptionPane.showMessageDialog(null, "주문완료 되었습니다. 감사합니다.");
				System.exit(0);
			}
		});

		// 초기화 버튼
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < menu.length; i++) {
					category[i].setEnabled(true);
				}
				for (int i = 0; i < table.getRowCount(); i++) {
					for (int j = 0; j < table.getColumnCount(); j++) {
						table.setValueAt(null, i, j);
					}
				}
				orderNumber=0;
			}

		});

		// 닫기버튼
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 컴포넌트
		add(pNorth, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);
		setVisible(true);

		// 끄기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
