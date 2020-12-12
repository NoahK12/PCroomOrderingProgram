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

public class Beverage {
	private JTextField smoothie_quan;
	private JTextField sprite_quan;
	private JTextField letsbee_quan;
	private JTextField pocari_quan;
	JFrame frame;
	JPanel panel;
	String productName = "";
	int count = 0;
	int totalPrice = 0;
	int seatNumber = 0;
	MainFrame mainFrame;
	DefaultTableModel tableModel;
	JTable table;

	public Beverage(MainFrame mainFrame) {
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
		// 스무디
		JButton smoothie = new JButton("스무디");
		smoothie.setBounds(47, 332, 105, 23);
		panel.add(smoothie);
		// 스무디 사진
		String imgPath1 = "src/PCroomOrderingSystem/스무디.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changeImg1 = originImg1.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon1 = new ImageIcon(changeImg1);
		JLabel smoothiep = new JLabel(Icon1);
		smoothiep.setBounds(30, 165, 150, 150);
		panel.add(smoothiep);
		// 스무디라면가격
		JLabel smoothie_price = new JLabel("4,000 원");
		smoothie_price.setBounds(74, 360, 57, 15);
		panel.add(smoothie_price);
		// 스무디 +
		JButton smoothie_plusbtn = new JButton("+");
		smoothie_plusbtn.setEnabled(false);
		smoothie_plusbtn.setBounds(129, 385, 44, 23);
		panel.setLayout(null);
		panel.add(smoothie_plusbtn);
		// 스무디 -
		JButton smoothie_minbtn = new JButton("-");
		smoothie_minbtn.setEnabled(false);
		smoothie_minbtn.setBounds(30, 385, 39, 23);
		panel.add(smoothie_minbtn);
		// 스무디 수량
		smoothie_quan = new JTextField();
		smoothie_quan.setBounds(79, 385, 39, 21);
		smoothie_quan.setText("0");
		smoothie_quan.setEditable(false);
		panel.add(smoothie_quan);
		smoothie_quan.setColumns(10);
		// 스무디 확인
		JButton smoothie_ok = new JButton("확인");
		smoothie_ok.setBounds(68, 418, 63, 23);
		smoothie_ok.setEnabled(false);
		panel.add(smoothie_ok);

		// 스무디 + 버튼이벤트
		smoothie_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				smoothie_quan.setText(count + "");
				smoothie_ok.setEnabled(true);
				if (count > 0) {
					smoothie_minbtn.setEnabled(true);
				}
			}
		});

		// 스무디 - 버튼이벤트
		smoothie_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					smoothie_quan.setText(count + "");
					smoothie_ok.setEnabled(true);
				} else {
					smoothie_minbtn.setEnabled(false);
				}

			}
		});

		// 스무디 확인 버튼 이벤트
		smoothie_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "스무디";
				totalPrice = 4000 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				smoothie_ok.setEnabled(false);
				smoothie.setEnabled(false);
				smoothie_plusbtn.setEnabled(false);
				smoothie_minbtn.setEnabled(false);
			}
		});

		// 스트라이프
		JButton sprite = new JButton("스트라이프");
		sprite.setBounds(246, 332, 105, 23);
		panel.add(sprite);
		// 스트라이프 사진
		String imgPath2 = "src/PCroomOrderingSystem/스프라이트.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changeImg2 = originImg2.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changeImg2);
		JLabel spritep = new JLabel(Icon2);
		spritep.setBounds(225, 165, 150, 150);
		panel.add(spritep);
		// 스트라이프 가격
		JLabel sprite_price = new JLabel("2,000 원");
		sprite_price.setBounds(275, 360, 57, 15);
		panel.add(sprite_price);
		// 스트라이프 +
		JButton sprite_plusbtn = new JButton("+");
		sprite_plusbtn.setEnabled(false);
		sprite_plusbtn.setBounds(330, 385, 44, 23);
		panel.setLayout(null);
		panel.add(sprite_plusbtn);
		// 스트라이프 -
		JButton sprite_minbtn = new JButton("-");
		sprite_minbtn.setEnabled(false);
		sprite_minbtn.setBounds(231, 385, 39, 23);
		panel.add(sprite_minbtn);
		// 스트라이프 수량
		sprite_quan = new JTextField();
		sprite_quan.setBounds(280, 385, 39, 21);
		sprite_quan.setText("0");
		sprite_quan.setEditable(false);
		panel.add(sprite_quan);
		sprite_quan.setColumns(10);
		// 스트라이프 확인
		JButton sprite_ok = new JButton("확인");
		sprite_ok.setBounds(264, 418, 63, 23);
		sprite_ok.setEnabled(false);
		panel.add(sprite_ok);

		// 스트라이프 + 버튼이벤트
		sprite_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				sprite_quan.setText(count + "");
				sprite_ok.setEnabled(true);
				if (count > 0) {
					sprite_minbtn.setEnabled(true);
				}
			}
		});

		// 스트라이프 - 버튼이벤트
		sprite_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					sprite_quan.setText(count + "");
					sprite_ok.setEnabled(true);
				} else {
					sprite_minbtn.setEnabled(false);
				}

			}
		});

		// 스트라이프 확인 버튼 이벤트
		sprite_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "스트라이프";
				totalPrice = 2000 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				sprite_ok.setEnabled(false);
				sprite.setEnabled(false);
				sprite_plusbtn.setEnabled(false);
				sprite_minbtn.setEnabled(false);
			}
		});

		// 레츠고
		JButton letsbee = new JButton("레츠고");
		letsbee.setBounds(449, 332, 97, 23);
		panel.add(letsbee);
		// 레츠고 사진
		String imgPath3 = "src/PCroomOrderingSystem/레스비.jpg";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changeImg3 = originImg3.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon3 = new ImageIcon(changeImg3);
		JLabel letsbeep = new JLabel(Icon3);
		letsbeep.setBounds(425, 165, 150, 150);
		panel.add(letsbeep);
		// 레츠고가격
		JLabel letsbee_price = new JLabel("800 원");
		letsbee_price.setBounds(474, 360, 57, 15);
		panel.add(letsbee_price);
		// 레츠고 +
		JButton letsbee_plusbtn = new JButton("+");
		letsbee_plusbtn.setEnabled(false);
		letsbee_plusbtn.setBounds(523, 385, 44, 23);
		panel.add(letsbee_plusbtn);
		// 레츠고 -
		JButton letsbee_minbtn = new JButton("-");
		letsbee_minbtn.setEnabled(false);
		letsbee_minbtn.setBounds(424, 385, 39, 23);
		panel.add(letsbee_minbtn);
		// 레츠고 수량
		letsbee_quan = new JTextField();
		letsbee_quan.setBounds(473, 385, 39, 21);
		letsbee_quan.setText("0");
		letsbee_quan.setEditable(false);
		panel.add(letsbee_quan);
		letsbee_quan.setColumns(10);
		// 레츠고 확인
		JButton letsbee_ok = new JButton("확인");
		letsbee_ok.setBounds(467, 418, 63, 23);
		letsbee_ok.setEnabled(false);
		panel.add(letsbee_ok);

		// 레츠고 + 버튼이벤트
		letsbee_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				letsbee_quan.setText(count + "");
				letsbee_ok.setEnabled(true);
				if (count > 0) {
					letsbee_minbtn.setEnabled(true);
				}
			}
		});

		// 레츠고 - 버튼이벤트
		letsbee_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					letsbee_quan.setText(count + "");
					letsbee_ok.setEnabled(true);
				} else {
					letsbee_minbtn.setEnabled(false);
				}

			}
		});

		// 레츠고 확인 버튼 이벤트
		letsbee_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "레츠고";
				totalPrice = 800 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				letsbee_ok.setEnabled(false);
				letsbee.setEnabled(false);
				letsbee_plusbtn.setEnabled(false);
				letsbee_minbtn.setEnabled(false);
			}
		});

		// 포카리
		JButton pocari = new JButton("포카리");
		pocari.setBounds(628, 332, 97, 23);
		panel.add(pocari);
		// 포카리 사진
		String imgPath4 = "src/PCroomOrderingSystem/포카리.jpg";
		ImageIcon originIcon4 = new ImageIcon(imgPath4);
		Image originImg4 = originIcon4.getImage();
		Image changeImg4 = originImg4.getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon Icon4 = new ImageIcon(changeImg4);
		JLabel pocarip = new JLabel(Icon4);
		pocarip.setBounds(605, 165, 150, 150);
		panel.add(pocarip);
		// 포카리가격
		JLabel pocari_price = new JLabel("2,500 원");
		pocari_price.setBounds(656, 360, 57, 15);
		panel.add(pocari_price);
		// 포카리 +
		JButton pocari_plusbtn = new JButton("+");
		pocari_plusbtn.setEnabled(false);
		pocari_plusbtn.setBounds(710, 385, 44, 23);
		panel.setLayout(null);
		panel.add(pocari_plusbtn);
		// 포카리 -
		JButton pocari_minbtn = new JButton("-");
		pocari_minbtn.setEnabled(false);
		pocari_minbtn.setBounds(611, 385, 39, 23);
		panel.add(pocari_minbtn);
		// 포카리 수량
		pocari_quan = new JTextField();
		pocari_quan.setBounds(660, 385, 39, 21);
		pocari_quan.setText("0");
		pocari_quan.setEditable(false);
		panel.add(pocari_quan);
		pocari_quan.setColumns(10);
		// 포카리 확인
		JButton pocari_ok = new JButton("확인");
		pocari_ok.setBounds(650, 418, 63, 23);
		pocari_ok.setEnabled(false);
		panel.add(pocari_ok);

		// 포카리 + 버튼이벤트
		pocari_plusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count = count + 1;
				pocari_quan.setText(count + "");
				pocari_ok.setEnabled(true);
				if (count > 0) {
					pocari_minbtn.setEnabled(true);
				}
			}
		});

		// 포카리 - 버튼이벤트
		pocari_minbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					count = count - 1;
					pocari_quan.setText(count + "");
					pocari_ok.setEnabled(true);
				} else {
					pocari_minbtn.setEnabled(false);
				}

			}
		});

		// 포카리 확인 버튼 이벤트
		pocari_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productName = "포카리";
				totalPrice = 2500 * count;
				Seat number = new Seat();
				seatNumber = number.getSeatNumber();
				Object[] rowData = { productName, count, totalPrice, seatNumber };
				tableModel.addRow(rowData);
				pocari_ok.setEnabled(false);
				pocari.setEnabled(false);
				pocari_plusbtn.setEnabled(false);
				pocari_minbtn.setEnabled(false);
			}
		});

		// 스무디 선택
		smoothie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sprite_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (letsbee_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (pocari_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					smoothie_plusbtn.setEnabled(true);
					smoothie_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 스트라이프 선택
		sprite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (smoothie_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (letsbee_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (pocari_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					sprite_plusbtn.setEnabled(true);
					sprite_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 레츠고 선택
		letsbee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (smoothie_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (sprite_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (pocari_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					letsbee_plusbtn.setEnabled(true);
					letsbee_minbtn.setEnabled(true);
					count = 0;
				}
			}
		});

		// 포카리 선택
		pocari.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (smoothie_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (sprite_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else if (letsbee_plusbtn.isEnabled())
					JOptionPane.showMessageDialog(null, "선택된 상품의 주문을 끝낸 후 다른 상품을 선택해 주세요.");
				else {
					pocari_plusbtn.setEnabled(true);
					pocari_minbtn.setEnabled(true);
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
				smoothie.setEnabled(true);
				sprite.setEnabled(true);
				letsbee.setEnabled(true);
				pocari.setEnabled(true);
				smoothie_plusbtn.setEnabled(false);
				sprite_plusbtn.setEnabled(false);
				letsbee_plusbtn.setEnabled(false);
				pocari_plusbtn.setEnabled(false);
				smoothie_minbtn.setEnabled(false);
				sprite_minbtn.setEnabled(false);
				letsbee_minbtn.setEnabled(false);
				pocari_minbtn.setEnabled(false);
				smoothie_quan.setText("0");
				sprite_quan.setText("0");
				letsbee_quan.setText("0");
				pocari_quan.setText("0");
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
		JLabel beverage = new JLabel("음료");
		beverage.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		beverage.setBounds(370, 26, 159, 61);
		panel.add(beverage);

		frame.setVisible(true);
		
		//배경화면
		String imgPath = "src/PCroomOrderingSystem/drink1.jpg";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changeImg = originImg.getScaledInstance(800, 700, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changeImg);
		JLabel background = new JLabel(Icon);
		background.setBounds(0, 0, 800, 700);
		panel.add(background);

	}

}