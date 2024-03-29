package bus.uigen.widgets.swing;

import bus.uigen.distributed.nongwt.NonGWTProxyGWTServerEndFactory;
import bus.uigen.widgets.ButtonGroupSelector;
import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.CheckBoxSelector;
import bus.uigen.widgets.ComboBoxSelector;
import bus.uigen.widgets.DesktopPaneSelector;
import bus.uigen.widgets.FlowLayoutSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.InternalFrameSelector;
import bus.uigen.widgets.LabelSelector;
import bus.uigen.widgets.MenuBarSelector;
import bus.uigen.widgets.MenuItemSelector;
import bus.uigen.widgets.MenuSelector;
import bus.uigen.widgets.NumberFormatSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.PasswordFieldSelector;
import bus.uigen.widgets.PopupMenuSelector;
import bus.uigen.widgets.ProxyGWTServerEndSelector;
import bus.uigen.widgets.RadioButtonSelector;
import bus.uigen.widgets.ScrollPaneSelector;
import bus.uigen.widgets.SliderSelector;
import bus.uigen.widgets.SplitPaneSelector;
import bus.uigen.widgets.TextAreaSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.ToolBarSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTFlowLayoutFactory;
import bus.uigen.widgets.awt.AWTGridLayoutFactory;
import bus.uigen.widgets.awt.AWTNumberFormatFactory;
import bus.uigen.widgets.table.ScrollableTableSelector;
import bus.uigen.widgets.table.TableSelector;
import bus.uigen.widgets.tree.TreeSelector;
import bus.uigen.widgets.universal.AUniversalWidget;

public class SwingToolkit extends VirtualToolkit{
	
	public SwingToolkit(){
		select();
	}
	
	public SwingToolkit(boolean isDistributed, String id){
		init(isDistributed, id);
	}
	
	public void select(){
		 maybeRegisterWidgets();
			FrameSelector.setFrameFactory(new SwingFrameFactory());
			InternalFrameSelector.setInternalFrameFactory(new SwingInternalFrameFactory());
			ButtonGroupSelector.setButtonGroupFactory(new SwingButtonGroupFactory());
			ButtonSelector.setButtonFactory(new SwingButtonFactory());
			CheckBoxSelector.setCheckBoxFactory(new SwingCheckBoxFactory());
			ComboBoxSelector.setComboBoxFactory(new SwingComboBoxFactory());
			DesktopPaneSelector.setDesktopPaneFactory(new SwingDesktopPaneFactory());
			GridLayoutSelector.setGridLayoutFactory(new AWTGridLayoutFactory());
			LabelSelector.setLabelFactory(new SwingLabelFactory());
			MenuBarSelector.setMenuBarFactory(new SwingMenuBarFactory());
			MenuItemSelector.setMenuItemFactory(new SwingMenuItemFactory());
			MenuSelector.setMenuFactory(new SwingMenuFactory());
			PopupMenuSelector.setMenuFactory(new SwingPopupMenuFactory());
			PanelSelector.setPanelFactory(new SwingPanelFactory());
			PasswordFieldSelector.setPasswordFieldFactory(new SwingPasswordFieldFactory());
			ProxyGWTServerEndSelector.setProxyGWTServerEndFactory(new NonGWTProxyGWTServerEndFactory());
			RadioButtonSelector.setRadioButtonFactory(new SwingRadioButtonFactory());
			ScrollableTableSelector.setScrollableTableFactory(new SwingScrollableTableFactory());
			ScrollPaneSelector.setScrollPaneFactory(new SwingScrollPaneFactory());
			SliderSelector.setSliderFactory(new SwingSliderFactory());
			SplitPaneSelector.setSplitPaneFactory(new SwingSplitPaneFactory());
			TableSelector.setTableFactory(new SwingTableFactory());
			TextAreaSelector.setTextAreaFactory(new SwingTextAreaFactory());
			TextFieldSelector.setTextFieldFactory(new SwingTextFieldFactory());
			ToolBarSelector.setToolBarFactory(new SwingToolBarFactory());
			TreeSelector.setTreeFactory(new SwingTreeFactory());
			TableSelector.setTableFactory(new SwingTableFactory());
			FlowLayoutSelector.setFlowLayoutFactory(new AWTFlowLayoutFactory());
			NumberFormatSelector.setNumberFormatFactory(new AWTNumberFormatFactory());
	}
	
	public boolean maybeRegisterWidgets(){
		boolean toReturn = super.maybeRegisterWidgets();
		AUniversalWidget.registerUniversalWidgetClasses();
		return toReturn;
	}

	public void startFrame(VirtualFrame frame) {
		receiveStartFrameCommand(frame);
		
		if(frame != null && VirtualToolkit.isDistributed()){
			VirtualToolkit.sendCommand(COMMAND_LABEL+COMMAND_START+frame.getID()+")");
		}
	}

	public void receiveStartFrameCommand(VirtualFrame frame) {
		if(frame != null){
			frame.setVisible(true);
		}
	}
}