package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_barangKeluar;

public class tm_barangKeluar extends AbstractTableModel{

     private List<model_barangKeluar> list = new ArrayList<>();
    
    public void tambahData(model_barangKeluar modKeluar) {
        list.add(modKeluar);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_barangKeluar modKeluar) {
        list.add(row, modKeluar);
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
    
    public void setData(List<model_barangKeluar> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_barangKeluar modKeluar) {
        list.set(index, modKeluar);
        fireTableRowsUpdated(index, index);
    }
    
    public model_barangKeluar getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getNo_keluar();
            case 1: return list.get(rowIndex).getTgl_keluar();
            case 2: return list.get(rowIndex).getTotal_keluar();
            case 3: return list.get(rowIndex).getMod_pengguna().getId_pengguna();
            case 4: return list.get(rowIndex).getMod_pengguna().getNama_pengguna();
            
            default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "No Keluar";
            case 1: return "Tanggal Keluar";
            case 2: return "Total Keluar";
            case 3: return "ID Pengguna";
            case 4: return "Nama Pengguna";
            
            default: return null;
        }
    }
    
}
