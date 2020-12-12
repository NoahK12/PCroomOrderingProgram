package PCroomOrderingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Noodle {
	private JTextField shinramen_quan;
	private JTextField chamramen_quan;
	private JTextField neoguri_quan;
	private JTextField jjapaguri_quan;
	JFrame frame;
	JPanel panel;
	String productName = "";
	int count = 0;
	int totalPrice = 0;
	int seatNumber = 0;
	MainFrame mainFrame;
	DefaultTableModel tableModel;
	JTable table;

	public Noodle(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 751);
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 245));
		frame.add(panel);
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 25);

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
		// 참깨라면
		JButton chamramen = new JButton("함깨라면");
		chamramen.setBounds(47, 332, 105, 23);
		panel.add(chamramen);
		// 참깨라면 사진
		String imgPath1 = "src/PCroomOrderingSystem/참깨라면.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changeImg1 = originImg1.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon1 = new ImageIcon(changeImg1);
		JLabel chamramenp = new JLabel(Icon1);
		chamramenp.setBounds(30, 165, 150, 150);
		panel.add(chamramenp);
		// 참깨라면가격
		JLabel chamramen_price = new JLabel("3,200 원");
		chamramen_price.setBounds(74, 360, 57, 15);
		panel.add(chamramen_price);
		// 참깨라면 +
		JButton chamramen_plusbtn = new JButton("+");
		chamramen_plusbtn.setEnabled(false);
		chamramen_plusbtn.setBounds(129, 385, 44, 23);
		panel.setLayout(null);
		panel.add(chamramen_plusbtn);
		// 참깨라면 -
		JButton chamramen_minbtn = new JButton("-");
		chamramen_minbtn.setEnabled(false);
		chamramen_minbtn.setBounds(30, 385, 39, 23);
		panel.add(chamramen_minbtn);
		// 참깨라면 수량
		chamramen_quan = new JTextField();
		chamramen_quan.setBounds(79, 385, 39, 21);
		chamramen_quan.setText("0");
		chamramen_quan.setEditable(false);
		panel.add(chamramen_quan);
		chamramen_quan.setColumns(10);
		// 참깨라면 확인
		JButton chamramen_ok = new JButton("확인");
		chamramen_ok.setBounds(68, 418, 63, 23);
		chamramen_ok.setEnabled(false);
		panel.add(chamramen_ok);

		// 참깨라면 + 버튼이벤트
		chamramen_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				chamramen_quan.setText(count + "");
				chamramen_ok.setEnabled(true);
				if (count > 0) {
					chamramen_minbtn.setEnabled(true);
				}
			}
		});

		// 참깨라면 - 버튼이벤트
		chamramen_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					chamramen_quan.setText(count + "");
					chamramen_ok.setEnabled(true);
				} else {
					chamramen_minbtn.setEnabled(false);
				}

			}
		});

		// 참깨라면 확인 버튼 이벤트
		chamramen_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				productName = "함깨라면";
				totalPrice = 3200 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				chamramen_ok.setEnabled(false);
				chamramen.setEnabled(false);
				chamramen_plusbtn.setEnabled(false);
				chamramen_minbtn.setEnabled(false);
			}
		});

		// 신라면
		JButton shinramen = new JButton("신나면");
		shinramen.setBounds(246, 332, 105, 23);
		panel.add(shinramen);
		// 신라면 사진
		String imgPath2 = "src/PCroomOrderingSystem/신라면.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changeImg2 = originImg2.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changeImg2);
		JLabel shinramenp = new JLabel(Icon2);
		shinramenp.setBounds(225, 165, 150, 150);
		panel.add(shinramenp);
		// 신라면 가격
		JLabel shinramen_price = new JLabel("2,800 원");
		shinramen_price.setBounds(275, 360, 57, 15);
		panel.add(shinramen_price);
		// 신라면 +
		JButton shinramen_plusbtn = new JButton("+");
		shinramen_plusbtn.setEnabled(false);
		shinramen_plusbtn.setBounds(330, 385, 44, 23);
		panel.setLayout(null);
		panel.add(shinramen_plusbtn);
		// 신라면 -
		JButton shinramen_minbtn = new JButton("-");
		shinramen_minbtn.setEnabled(false);
		shinramen_minbtn.setBounds(231, 385, 39, 23);
		panel.add(shinramen_minbtn);
		// 신라면 수량
		shinramen_quan = new JTextField();
		shinramen_quan.setBounds(280, 385, 39, 21);
		shinramen_quan.setText("0");
		shinramen_quan.setEditable(false);
		panel.add(shinramen_quan);
		shinramen_quan.setColumns(10);
		// 신라면 확인
		JButton shinramen_ok = new JButton("확인");
		shinramen_ok.setBounds(264, 418, 63, 23);
		shinramen_ok.setEnabled(false);
		panel.add(shinramen_ok);

		// 신라면 + 버튼이벤트
		shinramen_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				shinramen_quan.setText(count + "");
				shinramen_ok.setEnabled(true);
				if (count > 0) {
					shinramen_minbtn.setEnabled(true);
				}
			}
		});

		// 신라면 - 버튼이벤트
		shinramen_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					shinramen_quan.setText(count + "");
					shinramen_ok.setEnabled(true);
				} else {
					shinramen_minbtn.setEnabled(false);
				}

			}
		});

		// 신라면 확인 버튼 이벤트
		shinramen_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "신나면";
				totalPrice = 2800 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				shinramen_ok.setEnabled(false);
				shinramen.setEnabled(false);
				shinramen_plusbtn.setEnabled(false);
				shinramen_minbtn.setEnabled(false);
			}
		});

		// 자뻑구리
		JButton jjapaguri = new JButton("자뻑구리");
		jjapaguri.setBounds(449, 332, 97, 23);
		panel.add(jjapaguri);
		// 자뻑구리 사진
		String imgPath3 = "src/PCroomOrderingSystem/짜파구리.jpg";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changeImg3 = originImg3.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changeImg3);
		JLabel jjapagurip = new JLabel(Icon3);
		jjapagurip.setBounds(425, 165, 150, 150);
		panel.add(jjapagurip);
		// 자뻑구리가격
		JLabel jjapaguri_price = new JLabel("3,500 원");
		jjapaguri_price.setBounds(474, 360, 57, 15);
		panel.add(jjapaguri_price);
		// 자뻑구리 +
		JButton jjapaguri_plusbtn = new JButton("+");
		jjapaguri_plusbtn.setEnabled(false);
		jjapaguri_plusbtn.setBounds(523, 385, 44, 23);
		panel.add(jjapaguri_plusbtn);
		// 자뻑구리 -
		JButton jjapaguri_minbtn = new JButton("-");
		jjapaguri_minbtn.setEnabled(false);
		jjapaguri_minbtn.setBounds(424, 385, 39, 23);
		panel.add(jjapaguri_minbtn);
		// 자뻑구리 수량
		jjapaguri_quan = new JTextField();
		jjapaguri_quan.setBounds(473, 385, 39, 21);
		jjapaguri_quan.setText("0");
		jjapaguri_quan.setEditable(false);
		panel.add(jjapaguri_quan);
		jjapaguri_quan.setColumns(10);
		// 자뻑구리 확인
		JButton jjapaguri_ok = new JButton("확인");
		jjapaguri_ok.setBounds(467, 418, 63, 23);
		jjapaguri_ok.setEnabled(false);
		panel.add(jjapaguri_ok);

		// 자뻑구리 + 버튼이벤트
		jjapaguri_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				jjapaguri_quan.setText(count + "");
				jjapaguri_ok.setEnabled(true);
				if (count > 0) {
					jjapaguri_minbtn.setEnabled(true);
				}
			}
		});

		// 자뻑구리 - 버튼이벤트
		jjapaguri_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					jjapaguri_quan.setText(count + "");
					jjapaguri_ok.setEnabled(true);
				} else {
					jjapaguri_minbtn.setEnabled(false);
				}

			}
		});

		// 자뻑구리 확인 버튼 이벤트
		jjapaguri_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "자뻑구리";
				totalPrice = 3500 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				jjapaguri_ok.setEnabled(false);
				jjapaguri.setEnabled(false);
				jjapaguri_plusbtn.setEnabled(false);
				jjapaguri_minbtn.setEnabled(false);
			}
		});

		// 누구리
		JButton neoguri = new JButton("누구리");
		neoguri.setBounds(628, 332, 97, 23);
		panel.add(neoguri);
		// 누구리 사진
		String imgPath4 = "src/PCroomOrderingSystem/너구리.jpg";
		ImageIcon originIcon4 = new ImageIcon(imgPath4);
		Image originImg4 = originIcon4.getImage();
		Image changeImg4 = originImg4.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon4 = new ImageIcon(changeImg4);
		JLabel neogurip = new JLabel(Icon4);
		neogurip.setBounds(605, 165, 150, 150);
		panel.add(neogurip);
		// 누구리가격
		JLabel neoguri_price = new JLabel("3,000 원");
		neoguri_price.setBounds(656, 360, 57, 15);
		panel.add(neoguri_price);
		// 누구리 +
		JButton neoguri_plusbtn = new JButton("+");
		neoguri_plusbtn.setEnabled(false);
		neoguri_plusbtn.setBounds(710, 385, 44, 23);
		panel.setLayout(null);
		panel.add(neoguri_plusbtn);
		// 누구리 -
		JButton neoguri_minbtn = new JButton("-");
		neoguri_minbtn.setEnabled(false);
		neoguri_minbtn.setBounds(611, 385, 39, 23);
		panel.add(neoguri_minbtn);
		// 누구리 수량	
		neoguri_quan = new JTextField();
		neoguri_quan.setBounds(660, 385, 39, 21);
		neoguri_quan.setText("0");
		neoguri_quan.setEditable(false);
		panel.add(neoguri_quan);
		neoguri_quan.setColumns(10);
		// 누구리 확인
		JButton neoguri_ok = new JButton("확인");
		neoguri_ok.setBounds(650, 418, 63, 23);
		neoguri_ok.setEnabled(false);
		panel.add(neoguri_ok);

		// 누구리 + 버튼이벤트
		neoguri_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				neoguri_quan.setText(count + "");
				neoguri_ok.setEnabled(true);
				if (count > 0) {
					neoguri_minbtn.setEnabled(true);
				}
			}
		});

		// 누구리 - 버튼이벤트
		neoguri_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					neoguri_quan.setText(count + "");
					neoguri_ok.setEnabled(true);
				} else {
					neoguri_minbtn.setEnabled(false);
				}

			}
		});

		// 누구리 확인 버튼 이벤트
		neoguri_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "누구리";
				totalPrice = 3000 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				neoguri_ok.setEnabled(false);
				neoguri.setEnabled(false);
				neoguri_plusbtn.setEnabled(false);
				neoguri_minbtn.setEnabled(false);
			}
		});

		// 참깨라면 선택
		chamramen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (shinramen_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (jjapaguri_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (neoguri_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					chamramen_plusbtn.setEnabled(true);
					chamramen_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 신라면 선택
		shinramen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chamramen_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (jjapaguri_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (neoguri_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					shinramen_plusbtn.setEnabled(true);
					shinramen_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 자뻑구리 선택
		jjapaguri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (shinramen_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (chamramen_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (neoguri_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					jjapaguri_plusbtn.setEnabled(true);
					jjapaguri_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 누구리 선택
		neoguri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (shinramen_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (jjapaguri_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (chamramen_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					neoguri_plusbtn.setEnabled(true);
					neoguri_minbtn.setEnabled(true);
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
					chamramen.setEnabled(true);
					shinramen.setEnabled(true);
					jjapaguri.setEnabled(true);
					neoguri.setEnabled(true);
					chamramen_plusbtn.setEnabled(false);
					shinramen_plusbtn.setEnabled(false);
					jjapaguri_plusbtn.setEnabled(false);
					neoguri_plusbtn.setEnabled(false);
					chamramen_minbtn.setEnabled(false);
					shinramen_minbtn.setEnabled(false);
					jjapaguri_minbtn.setEnabled(false);
					neoguri_minbtn.setEnabled(false);
					chamramen_quan.setText("0");
					shinramen_quan.setText("0");
					jjapaguri_quan.setText("0");
					neoguri_quan.setText("0");
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
		JLabel ramen = new JLabel("식사류");
		
		ramen.setFont(font1);
		ramen.setBounds(360, 26, 159, 61);
		panel.add(ramen);

		frame.setVisible(true);

		//배경화면
		String imgPath = "src/PCroomOrderingSystem/ramen.jpg";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changeImg = originImg.getScaledInstance(800, 750, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changeImg);
		JLabel background = new JLabel(Icon);
		background.setBounds(0, 0, 800, 750);
		panel.add(background);
	}

}