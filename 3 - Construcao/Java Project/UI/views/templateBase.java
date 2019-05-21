package views;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class templateBase {
	public JButton BaseBtn = new JButton();
	public JButton BaseBtnMargin = new JButton();

	public JTextField BaseTxt;
	public JPasswordField BaseTxtPass;
	public JLabel BaseEspace;
	public JLabel BaseLbl;

	public JLabel BaseLblTextCenter;

	public JLabel basicTextLabelCenter(String txtHtml) {
		JLabel lbl = new JLabel();
		lbl.setForeground(Color.WHITE);
		lbl.setFont( new Font("Arial", 0, 15));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVerticalAlignment(SwingConstants.CENTER);
		lbl.setText(appStart.UtilsString.setText(txtHtml));
		return lbl;
	}
	
	public JLabel basicTextLabelCenterMR(String txtHtml) {
		JLabel lbl = new JLabel();
		lbl.setForeground(Color.WHITE);
		lbl.setFont( new Font("Arial", 0, 20));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVerticalAlignment(SwingConstants.CENTER);
		lbl.setText(appStart.UtilsString.setText(txtHtml));
		return lbl;
	}

	public templateBase() {
		BaseBtn = new JButton();
		setColorButton(BaseBtn, templateBase.enColorButton.Primary);
		BaseBtn.setContentAreaFilled(false);
		BaseBtn.setOpaque(true);
		BaseBtn.setPreferredSize(new Dimension(200, 40));
		BaseBtn.setFocusPainted(false);
		BaseBtn.setBorder(BorderFactory.createEmptyBorder());
		BaseBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		BaseBtnMargin = new JButton();
		setColorButton(BaseBtnMargin, templateBase.enColorButton.Primary);
		BaseBtnMargin.setContentAreaFilled(false);
		BaseBtnMargin.setOpaque(true);
		BaseBtnMargin.setPreferredSize(new Dimension(200, 40));
		BaseBtnMargin.setFocusPainted(false);
		BaseBtnMargin.setBorder(BorderFactory.createEmptyBorder());
		BaseBtnMargin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BaseBtnMargin.setMargin(new Insets(10, 10, 10, 10));

		BaseTxt = new JTextField();
		BaseTxt.setPreferredSize(new Dimension(200, 40));

		BaseTxtPass = new JPasswordField();
		BaseTxtPass.setPreferredSize(new Dimension(200, 40));

		BaseEspace = new JLabel();
		BaseEspace.setPreferredSize(new Dimension(1, 40));

		BaseLbl = new JLabel();
		BaseLbl.setForeground(Color.WHITE);
		// BaseLbl.setPreferredSize(new Dimension(200, 40));

		BaseLblTextCenter = new JLabel();
		BaseLblTextCenter.setForeground(Color.WHITE);
		BaseLblTextCenter.setHorizontalAlignment(SwingConstants.CENTER);
		BaseLblTextCenter.setVerticalAlignment(SwingConstants.CENTER);
	}

	public static enum enColorButton {
		Primary, Secondary, Success, Danger, Warning, Info, Light, Dark, Invisible;
	}

	public static void setColorButton(JButton btn, enColorButton color) {

		if (color == enColorButton.Primary) {
			btn.setBackground(new Color(0, 123, 255));
			btn.setForeground(Color.WHITE);
		}

		if (color == enColorButton.Secondary) {
			btn.setBackground(new Color(108, 117, 125));
			btn.setForeground(Color.WHITE);
		}

		if (color == enColorButton.Success) {
			btn.setBackground(new Color(40, 167, 69));
			btn.setForeground(Color.WHITE);
		}

		if (color == enColorButton.Danger) {
			btn.setBackground(new Color(220, 53, 69));
			btn.setForeground(Color.WHITE);
		}

		if (color == enColorButton.Warning) {
			btn.setBackground(new Color(255, 193, 7));
			btn.setForeground(Color.BLACK);
		}

		if (color == enColorButton.Info) {
			btn.setBackground(new Color(23, 162, 184));
			btn.setForeground(Color.WHITE);
		}

		if (color == enColorButton.Light) {
			btn.setBackground(new Color(248, 249, 250));
			btn.setForeground(Color.BLACK);
		}

		if (color == enColorButton.Dark) {
			btn.setBackground(new Color(52, 58, 64));
			btn.setForeground(Color.WHITE);
		}
		if (color == enColorButton.Invisible) {
			btn.setBackground(new Color(20, 30, 40));
			btn.setForeground(Color.WHITE);
		}
	}
}
