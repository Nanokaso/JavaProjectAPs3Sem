package appStart;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import models.IAction;

public class Frame {
	public static JFrame frame = null;

	public static void PrepareNewFrame(IAction model) {

		if (frame == null) {
			frame = new JFrame();
		} else {
			frame.dispose();
			frame = new JFrame();
		}
		frame.setTitle(model.TitlePage);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		frame.setSize(dim.width - 350, dim.height - 100);
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

	}

	public static void ShowFrame() {
		if (frame != null) {
			// frame.pack();
			frame.setVisible(true);
		}
	}

	public static void SetNewSize(int w, int h) {
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		frame.setSize(w, h);
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}

}
