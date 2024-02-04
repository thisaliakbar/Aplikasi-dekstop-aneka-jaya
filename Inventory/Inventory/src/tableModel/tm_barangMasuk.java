package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_barangMasuk;

public class tm_barangMasuk extends AbstractTableModel{
    private List<model_barangMasuk> list = new ArrayList<>();
    
    public void tambahData(model_barangMasuk modMasuk) {
        list.add(modMasuk);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_barangMasuk modMasuk) {
        list.add(row, modMasuk);
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
    
    public void setData(List<model_barangMasuk> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_barangMasuk modMasuk) {
        list.set(index, modMasuk);
        fireTableRowsUpdated(index, index);
    }
    
    public model_barangMasuk getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getNo_masuk();
            case 1: return list.get(rowIndex).getTgl_masuk();
            case 2: return list.get(rowIndex).getTotal_masuk();
            case 3: return list.get(rowIndex).getMod_pengguna().getId_pengguna();
            case 4: return list.get(rowIndex).getMod_pengguna().getNama_pengguna();
            case 5: return list.get(rowIndex).getMod_supliyer().getId_supliyer();
            case 6: return list.get(rowIndex).getMod_supliyer().getNama_supliyer();
            default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "No Masuk";
            case 1: return "Tanggal Masuk";
            case 2: return "Total Masuk";
            case 3: return "ID Pengguna";
            case 4: return "Nama Pengguna";
            case 5: return "ID Supplier";
            case 6: return "Nama Supplier";
            
            default: return null;
        }
    }
}
