package bus.uigen.widgets.swing;

	public VirtualFrame createFrame () {
		JFrame frame = new JFrame();
		//panel.setBackground(Color.white);
		VirtualFrame toReturn = SwingFrame.virtualFrame(frame);
		toReturn.init();
		return toReturn;
	}
		return toReturn;
		//return new Panel();
 }