package view;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import controller.ControleCanal;
import dao.ExceptionDAO;
import model.Canal;

public class CanalListCellRenderer extends DefaultListCellRenderer{
	
	public Component getListCellRenderer(JList<?> list, Object value, int index, 
			boolean isSelected,  boolean cellHasFocus) {
		if(value instanceof Canal) {
			Canal canal = (Canal) value;
			value = canal.getEmissora();
		}
		return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	}
}
