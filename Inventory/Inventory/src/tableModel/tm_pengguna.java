package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_pengguna;

public class tm_pengguna extends AbstractTableModel{
    private List<model_pengguna> list = new ArrayList<>();
    
    public void tambahData(model_pengguna mod_pengguna) {
        list.add(mod_pengguna);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_pengguna mod_pengguna) {
        list.add(row, mod_pengguna);
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
    
    public void setData(List<model_pengguna> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_pengguna mod_pengguna) {
        list.set(index, mod_pengguna);
        fireTableRowsUpdated(index, index);
    }
    
    public model_pengguna getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getId_pengguna();
            case 1: return list.get(rowIndex).getNama_pengguna();
            case 2: return list.get(rowIndex).getUsername();
//            case 3: return list.get(rowIndex).getPassword();
            case 3: return list.get(rowIndex).getTelp_pengguna();
            case 4: return list.get(rowIndex).getAlamat_pengguna();
            case 5: return list.get(rowIndex).getLevel();
            
            default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID Pengguna";
            case 1: return "Nama Pengguna";
            case 2: return "Username";
//            case 3: return "Password";
            case 3: return "No Telepon";
            case 4: return "Alamat";
            case 5: return "Level";
            
            default: return null;
        }
    }
}
