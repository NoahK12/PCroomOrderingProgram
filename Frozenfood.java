package PCroomOrderingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Frozenfood {
	private JTextField chicken_quan;
	private JTextField tangsoo_quan;
	private JTextField woodong_quan;
	private JTextField mandoo_quan;
	JFrame frame;
	JPanel panel;
	String productName = "";
	int count = 0;
	int totalPrice = 0;
	int seatNumber = 0;
	MainFrame mainFrame;
	DefaultTableModel tableModel;
	JTable table;

	public Frozenfood(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 751);
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 245));
		frame.add(panel);

		// 임시장바구니
		String[] cols = { "상품명", "주문 수량", "총 가격", "좌석번호" };
		tableModel = new DefaultTableModel(cols, 0);
		table = new JTable(tableModel);
		table.setRowHeight(20);
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
		scrollPane.setBounds(50, 500, 700, 100);
		panel.add(scrollPane);

		// 메뉴 생성
		// 치킨
		JButton chicken = new JButton("샤넬치킨");
		chicken.setBounds(50, 332, 97, 23);
		panel.add(chicken);
		// 치킨 사진
		String imgPath1 = "src/PCroomOrderingSystem/슈넬1.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changeImg1 = originImg1.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon1 = new ImageIcon(changeImg1);
		JLabel chickenp = new JLabel(Icon1);
		chickenp.setBounds(20, 165, 150, 150);
		panel.add(chickenp);
		// 치킨가격
		JLabel chicken_price = new JLabel("4,000 원");
		chicken_price.setBounds(74, 360, 57, 15);
		panel.add(chicken_price);
		// 치킨 +
		JButton chicken_plusbtn = new JButton("+");
		chicken_plusbtn.setEnabled(false);
		chicken_plusbtn.setBounds(129, 385, 44, 23);
		panel.setLayout(null);
		panel.add(chicken_plusbtn);
		// 치킨 -
		JButton chicken_minbtn = new JButton("-");
		chicken_minbtn.setEnabled(false);
		chicken_minbtn.setBounds(30, 385, 39, 23);
		panel.add(chicken_minbtn);
		// 치킨 수량
		chicken_quan = new JTextField();
		chicken_quan.setBounds(79, 385, 39, 21);
		chicken_quan.setText("0");
		chicken_quan.setEditable(false);
		panel.add(chicken_quan);
		chicken_quan.setColumns(10);
		// 치킨 확인
		JButton chicken_ok = new JButton("확인");
		chicken_ok.setBounds(68, 418, 63, 23);
		chicken_ok.setEnabled(false);
		panel.add(chicken_ok);

		// 치킨 + 버튼이벤트
		chicken_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				chicken_quan.setText(count + "");
				chicken_ok.setEnabled(true);
				if (count > 0) {
					chicken_minbtn.setEnabled(true);
				}
			}
		});

		// 치킨 - 버튼이벤트
		chicken_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					chicken_quan.setText(count + "");
					chicken_ok.setEnabled(true);
				} else {
					chicken_minbtn.setEnabled(false);
				}

			}
		});

		// 치킨 확인 버튼 이벤트
		chicken_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "샤넬치킨";
				totalPrice = 4000 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				chicken_ok.setEnabled(false);
				chicken.setEnabled(false);
				chicken_plusbtn.setEnabled(false);
				chicken_minbtn.setEnabled(false);
			}
		});

		// 탕수육
		JButton tangsooyook = new JButton("찰싹 탕수육");
		tangsooyook.setBounds(246, 332, 105, 23);
		panel.add(tangsooyook);
		// 탕수 사진
		String imgPath2 = "src/PCroomOrderingSystem/탕수육.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changeImg2 = originImg2.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changeImg2);
		JLabel tangsoop = new JLabel(Icon2);
		tangsoop.setBounds(225, 165, 150, 150);
		panel.add(tangsoop);
		// 탕수가격
		JLabel tangsoo_price = new JLabel("4,500 원");
		tangsoo_price.setBounds(275, 360, 57, 15);
		panel.add(tangsoo_price);
		// 탕수 +
		JButton tangsoo_plusbtn = new JButton("+");
		tangsoo_plusbtn.setBounds(330, 385, 45, 23);
		tangsoo_plusbtn.setEnabled(false);
		panel.add(tangsoo_plusbtn);
		// 탕수 -
		JButton tangsoo_minbtn = new JButton("-");
		tangsoo_minbtn.setBounds(231, 385, 39, 23);
		tangsoo_minbtn.setEnabled(false);
		panel.add(tangsoo_minbtn);
		// 탕수 수량
		tangsoo_quan = new JTextField();
		tangsoo_quan.setBounds(280, 386, 39, 21);
		tangsoo_quan.setText("0");
		tangsoo_quan.setEditable(false);
		panel.add(tangsoo_quan);
		tangsoo_quan.setColumns(10);
		// 탕수 확인
		JButton tangsoo_ok = new JButton("확인");
		tangsoo_ok.setBounds(264, 418, 63, 23);
		tangsoo_ok.setEnabled(false);
		panel.add(tangsoo_ok);

		// 탕수 + 버튼이벤트
		tangsoo_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				tangsoo_quan.setText(count + "");
				tangsoo_ok.setEnabled(true);
				if (count > 0) {
					tangsoo_minbtn.setEnabled(true);
				}
			}
		});

		// 탕수 - 버튼이벤트
		tangsoo_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					tangsoo_quan.setText(count + "");
					tangsoo_ok.setEnabled(true);
				} else {
					tangsoo_minbtn.setEnabled(false);
				}

			}
		});

		// 탕수 확인 버튼 이벤트
		tangsoo_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "찰싹 탕수육";
				totalPrice = 4500 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				tangsoo_ok.setEnabled(false);
				tangsooyook.setEnabled(false);
				tangsoo_plusbtn.setEnabled(false);
				tangsoo_minbtn.setEnabled(false);
			}

		});

		// 우동
		JButton woodong = new JButton("크린 우동");
		woodong.setBounds(449, 332, 97, 23);
		panel.add(woodong);
		// 우동 사진
		String imgPath3 = "src/PCroomOrderingSystem/우동.jpg";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changeImg3 = originImg3.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changeImg3);
		JLabel woodongp = new JLabel(Icon3);
		woodongp.setBounds(425, 165, 150, 150);
		panel.add(woodongp);
		// 우동가격
		JLabel woodong_price = new JLabel("4,300 원");
		woodong_price.setBounds(473, 360, 57, 15);
		panel.add(woodong_price);
		// 우동 +
		JButton woodong_plusbtn = new JButton("+");
		woodong_plusbtn.setBounds(523, 385, 44, 23);
		woodong_plusbtn.setEnabled(false);
		panel.add(woodong_plusbtn);
		// 우동 -
		JButton woodong_minbtn = new JButton("-");
		woodong_minbtn.setBounds(424, 385, 39, 23);
		woodong_minbtn.setEnabled(false);
		panel.add(woodong_minbtn);
		// 우동 수량
		woodong_quan = new JTextField();
		woodong_quan.setText("0");
		woodong_quan.setColumns(10);
		woodong_quan.setBounds(473, 386, 39, 21);
		woodong_quan.setEditable(false);
		panel.add(woodong_quan);
		// 우동 확인
		JButton woodong_ok = new JButton("확인");
		woodong_ok.setBounds(467, 418, 63, 23);
		woodong_ok.setEnabled(false);
		panel.add(woodong_ok);

		// 우동 + 버튼이벤트
		woodong_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				woodong_quan.setText(count + "");
				woodong_ok.setEnabled(true);
				if (count > 0) {
					woodong_minbtn.setEnabled(true);
				}
			}
		});

		// 우동 - 버튼이벤트
		woodong_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					woodong_quan.setText(count + "");
					woodong_ok.setEnabled(true);
				} else {
					woodong_minbtn.setEnabled(false);
				}

			}
		});

		// 우동 확인 버튼 이벤트
		woodong_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "크린 우동";
				totalPrice = 4300 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				woodong_ok.setEnabled(false);
				woodong.setEnabled(false);
				woodong_plusbtn.setEnabled(false);
				woodong_minbtn.setEnabled(false);
			}
		});

		// 만두
		JButton mandoo = new JButton("샤오미 만두");
		mandoo.setBounds(628, 332, 105, 23);
		panel.add(mandoo);
		// 만두사진
		String imgPath4 = "src/PCroomOrderingSystem/만두.jpg";
		ImageIcon originIcon4 = new ImageIcon(imgPath4);
		Image originImg4 = originIcon4.getImage();
		Image changeImg4 = originImg4.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon4 = new ImageIcon(changeImg4);
		JLabel mandoop = new JLabel(Icon4);
		mandoop.setBounds(605, 165, 150, 150);
		panel.add(mandoop);
		// 만두가격
		JLabel mandoo_price = new JLabel("3,000 원");
		mandoo_price.setBounds(656, 360, 57, 15);
		panel.add(mandoo_price);
		// 만두 +
		JButton mandoo_plusbtn = new JButton("+");
		mandoo_plusbtn.setBounds(710, 385, 44, 23);
		mandoo_plusbtn.setEnabled(false);
		panel.add(mandoo_plusbtn);
		// 만두 -
		JButton mandoo_minbtn = new JButton("-");
		mandoo_minbtn.setBounds(611, 385, 39, 23);
		mandoo_minbtn.setEnabled(false);
		panel.add(mandoo_minbtn);
		// 만두 수량
		mandoo_quan = new JTextField();
		mandoo_quan.setText("0");
		mandoo_quan.setColumns(10);
		mandoo_quan.setBounds(660, 386, 39, 21);
		mandoo_quan.setEditable(false);
		panel.add(mandoo_quan);
		// 만두 확인
		JButton mandoo_ok = new JButton("확인");
		mandoo_ok.setBounds(650, 418, 63, 23);
		mandoo_ok.setEnabled(false);
		panel.add(mandoo_ok);

		// 만두 + 버튼이벤트
		mandoo_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				mandoo_quan.setText(count + "");
				mandoo_ok.setEnabled(true);
				if (count > 0) {
					mandoo_minbtn.setEnabled(true);
				}
			}
		});

		// 만두 - 버튼이벤트
		mandoo_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					mandoo_quan.setText(count + "");
					mandoo_ok.setEnabled(true);
				} else {
					mandoo_minbtn.setEnabled(false);
				}

			}
		});

		// 만두 확인 버튼 이벤트
		mandoo_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "샤오미 만두";
				totalPrice = 3000 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				mandoo_ok.setEnabled(false);
				mandoo.setEnabled(false);
				mandoo_plusbtn.setEnabled(false);
				mandoo_minbtn.setEnabled(false);
			}
		});

		// 치킨 선택
		chicken.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tangsoo_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (woodong_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (mandoo_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					chicken_plusbtn.setEnabled(true);
					chicken_minbtn.setEnabled(true);
					count = 0;
				}

			}
		});

		// 탕수 선택
		tangsooyook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chicken_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (woodong_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (mandoo_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					tangsoo_plusbtn.setEnabled(true);
					tangsoo_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 우동 선택
		woodong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tangsoo_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (chicken_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (mandoo_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					woodong_plusbtn.setEnabled(true);
					woodong_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 만두 선택
		mandoo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tangsoo_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (woodong_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (chicken_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					mandoo_plusbtn.setEnabled(true);
					mandoo_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 담기
		JButton addcart = new JButton("담기");
		addcart.setBounds(190, 655, 97, 23);
		panel.add(addcart);
		addcart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < table.getRowCount(); i++) {
					for (int j = 0; j < table.getColumnCount(); j++) {
						mainFrame.tableModel.setValueAt(table.getValueAt(i, j), mainFrame.orderNumber, j);
					}
					++mainFrame.orderNumber;
				}
				frame.dispose();
			}
		});
		// 초기화
		JButton clear = new JButton("초기화");
		clear.setBounds(350, 655, 97, 23);
		panel.add(clear);
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "장바구니에 담겨진 상품이 없습니다.");
				} else {
					chicken.setEnabled(true);
					tangsooyook.setEnabled(true);
					woodong.setEnabled(true);
					mandoo.setEnabled(true);
					chicken_plusbtn.setEnabled(false);
					tangsoo_plusbtn.setEnabled(false);
					woodong_plusbtn.setEnabled(false);
					mandoo_plusbtn.setEnabled(false);
					chicken_minbtn.setEnabled(false);
					tangsoo_minbtn.setEnabled(false);
					woodong_minbtn.setEnabled(false);
					mandoo_minbtn.setEnabled(false);
					chicken_quan.setText("0");
					tangsoo_quan.setText("0");
					woodong_quan.setText("0");
					mandoo_quan.setText("0");
					count = 0;
					for (int i = table.getRowCount() - 1; i >= 0; i--) {
						tableModel.removeRow(i);
					}
				}
			}

		});

		// 취소
		JButton cancel = new JButton("취소");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		cancel.setBounds(515, 655, 97, 23);
		panel.add(cancel);

		// 상품 종류
		JLabel frozenproduct = new JLabel("냉동식품");
		frozenproduct.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		frozenproduct.setBounds(345, 26, 159, 61);
		panel.add(frozenproduct);

		frame.setVisible(true);
		
		//배경화면
		String imgPath = "src/PCroomOrderingSystem/frozen1.jpg";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changeImg = originImg.getScaledInstance(800, 700, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changeImg);
		JLabel background = new JLabel(Icon);
		background.setBounds(0, 0, 800, 700);
		panel.add(background);

	}

}