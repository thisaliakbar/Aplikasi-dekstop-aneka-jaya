package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_supliyer;

public class tm_supliyer extends AbstractTableModel{
    private List<model_supliyer> list = new ArrayList<>();
    
    public void tambahData(model_supliyer mod_sup) {
        list.add(mod_sup);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    public void perbaruiData(int row,model_supliyer mod_sup) {
        list.add(row,mod_sup);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
    }
    public void hapusData(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
    }
    public void clear() {
        list.clear();
        fireTableDataChanged();
    }
    public void setData(List<model_supliyer> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, model_supliyer mod_sup) {
        list.set(index, mod_sup);
        fireTableRowsUpdated(index, index);
    }
    public model_supliyer getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getId_supliyer();
            case 1: return list.get(rowIndex).getNama_supliyer();
            case 2: return list.get(rowIndex).getTelp_supliyer();
            case 3: return list.get(rowIndex).getAlamat_supliyer();
            
            default: return null;
        }
    }
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID Supplier";
            case 1: return "Nama Supplier";
            case 2: return "No Telephone";
            case 3: return "Alamat";
            
            default: return null;
        }
    }
}
