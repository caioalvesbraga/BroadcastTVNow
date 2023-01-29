package view;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import controller.ControleCanal;
import dao.ExceptionDAO;
import model.Canal;

/**
 * a classe CanalListCellRenderer herda o componente DefaultListCellRenderer e define um renderizador de 
 * lista de células com instância de Canal
 * @author Caio Alves Braga
 *
 */
public class CanalListCellRenderer extends DefaultListCellRenderer{
	
	/**
	 * O método getListCellRenderer retorna a rederização da lista de células com os valores de emissora do Canal
	 * @param list
	 * @param value
	 * @param index
	 * @param isSelected
	 * @param cellHasFocus
	 * @return
	 */
	public Component getListCellRenderer(JList<?> list, Object value, int index, 
			boolean isSelected,  boolean cellHasFocus) {
		if(value instanceof Canal) {
			Canal canal = (Canal) value;
			value = canal.getEmissora();
		}
		return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	}
}
