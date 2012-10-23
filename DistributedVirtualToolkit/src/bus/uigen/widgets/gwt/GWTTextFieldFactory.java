package bus.uigen.widgets.gwt;

import bus.uigen.widgets.TextFieldFactory;
import bus.uigen.widgets.VirtualTextField;

public class GWTTextFieldFactory implements TextFieldFactory{

	public VirtualTextField createTextField() {
		return new GWTTextField();
	}

	public VirtualTextField createTextField(String text) {
		return new GWTTextField(text);
	}

}
