package bus.uigen.widgets.awt;

	public VirtualFrame createFrame () {
		Frame frame = new Frame();
		//panel.setBackground(Color.white);
		return AWTFrame.virtualFrame(frame);
	}
 }