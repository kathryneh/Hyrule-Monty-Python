package bus.uigen.widgets.swing;import javax.swing.JSlider;import bus.uigen.widgets.SliderFactory;import bus.uigen.widgets.VirtualSlider;

public class SwingSliderFactory implements SliderFactory {	static int id;
			public VirtualSlider createSlider () {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJSlider();	}	public VirtualSlider createSlider (int val) {		/*		Container panel = new JPanel();		panel.setName("" + getNewID());		//panel.setBackground(Color.white);		return panel;		//return new Panel();		//return new JPanel();		 *		 */		return createJSlider(val);	}	 static int getNewID() {		return id++;	}	public static SwingSlider createJSlider (int value) {		JSlider slider = new JSlider(value);		SwingSlider toReturn = SwingSlider.virtualSlider(slider);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}		public static SwingSlider createJSlider () {		JSlider slider = new JSlider();		SwingSlider toReturn = SwingSlider.virtualSlider(slider);		toReturn.init();		return toReturn;		//return new Panel();		//return new JPanel();	}	  
 }
