package views;

import java.awt.*;

import javax.swing.*;

public class templateBase {
	public JButton BaseBtn = new JButton();
	public JButton BaseBtnMargin = new JButton();
	
	public JTextField BaseTxt;
	public JPasswordField BaseTxtPass;
	public JLabel BaseEspace;
	public JLabel BaseLbl;
	
	public JLabel BaseLblTextCenter;

	public templateBase() {
		BaseBtn = new JButton();
		BaseBtn.setBackground(Color.orange);
		BaseBtn.setContentAreaFilled(false);
		BaseBtn.setOpaque(true);
		BaseBtn.setPreferredSize(new Dimension(200, 40));
		BaseBtn.setFocusPainted(false);
		BaseBtn.setBorder(BorderFactory.createEmptyBorder());
		BaseBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		BaseBtnMargin = new JButton();
		BaseBtnMargin.setBackground(Color.orange);
		BaseBtnMargin.setContentAreaFilled(false);
		BaseBtnMargin.setOpaque(true);
		BaseBtnMargin.setPreferredSize(new Dimension(200, 40));
		BaseBtnMargin.setFocusPainted(false);
		BaseBtnMargin.setBorder(BorderFactory.createEmptyBorder());
		BaseBtnMargin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BaseBtnMargin.setMargin(new Insets(10,10,10,10));

		BaseTxt = new JTextField();
		BaseTxt.setPreferredSize(new Dimension(200, 40));

		BaseTxtPass = new JPasswordField();
		BaseTxtPass.setPreferredSize(new Dimension(200, 40));

		BaseEspace = new JLabel();
		BaseEspace.setPreferredSize(new Dimension(1, 40));
		
		BaseLbl = new JLabel();
		//BaseLbl.setPreferredSize(new Dimension(200, 40));
		
		BaseLblTextCenter = new JLabel();
		BaseLblTextCenter.setHorizontalAlignment(SwingConstants.CENTER);
		BaseLblTextCenter.setVerticalAlignment(SwingConstants.CENTER);
	}
}
