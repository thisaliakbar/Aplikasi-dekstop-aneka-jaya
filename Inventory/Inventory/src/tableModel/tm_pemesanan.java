package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_pemesanan;

public class tm_pemesanan extends AbstractTableModel{
    private List<model_pemesanan> list = new ArrayList<>();
    
    public void tambahData(model_pemesanan mod_pemesanan) {
        list.add(mod_pemesanan);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_pemesanan mod_pemesanan) {
        list.add(row, mod_pemesanan);
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
    
    public void setData(List<model_pemesanan> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_pemesanan mod_pemesanan) {
        list.set(index, mod_pemesanan);
        fireTableRowsUpdated(index, index);
    }
    
    public model_pemesanan getData(int index) {
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
            case 0: return list.get(rowIndex).getNo_pesan();
            case 1: return list.get(rowIndex).getTgl_pesan();
            case 2: return list.get(rowIndex).getTotal_pesan();
            case 3: return list.get(rowIndex).getModel_pengguna_pem().getId_pengguna();
            case 4: return list.get(rowIndex).getModel_pengguna_pem().getNama_pengguna();
            case 5: return list.get(rowIndex).getModel_supliyer_pem().getId_supliyer();
            case 6: return list.get(rowIndex).getModel_supliyer_pem().getNama_supliyer();
            
            default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "No Pesan";
            case 1: return "Tanggal Pesan";
            case 2: return "Total Pesan";
            case 3: return "ID Pengguna";
            case 4: return "Nama Pengguna";
            case 5: return "ID Supplier";
            case 6: return "Nama Supplier";
            
            default: return null;
        }
    }
}
