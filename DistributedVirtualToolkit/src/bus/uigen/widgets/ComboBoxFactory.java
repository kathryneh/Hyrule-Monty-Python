package bus.uigen.widgets;import java.util.Vector;;
public interface ComboBoxFactory {
  public  VirtualComboBox createComboBox  (Object[] values);  public  VirtualComboBox createComboBox  (Vector<Object> values);  public  VirtualComboBox createComboBox  ();  
 }
