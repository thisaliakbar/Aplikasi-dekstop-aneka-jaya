package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_detail_pemesanan;

public class tm_detPemesanan extends AbstractTableModel{
    private List<model_detail_pemesanan> list = new ArrayList<>();
    
    public void tambahData(model_detail_pemesanan mod_detPemesanan) {
        list.add(mod_detPemesanan);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    public void perbaruiData(int row, model_detail_pemesanan mod_detPemesanan) {
        list.add(row, mod_detPemesanan);
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
    public void setData(List<model_detail_pemesanan> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, model_detail_pemesanan mod_detPemesanan) {
        list.set(index, mod_detPemesanan);
        fireTableRowsUpdated(index, index);
    }
    
    public model_detail_pemesanan getData(int index) {
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
            case 0: return list.get(rowIndex).getMod_pemesanan_detPem().getNo_pesan();
            case 1: return list.get(rowIndex).getMod_barang_detPem().getKode_barang();
            case 2: return list.get(rowIndex).getMod_barang_detPem().getNama_barang();
            case 3: return list.get(rowIndex).getMod_barang_detPem().getHarga();
            case 4: return list.get(rowIndex).getJml_pesan();
            case 5: return list.get(rowIndex).getSubtotal_pesan();
            case 6: return list.get(rowIndex).getStatus();
            
            default: return null;
        }
    }
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "No Pesan";
            case 1: return "Kode Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga";
            case 4: return "Jumlah Pesan";
            case 5: return "Subtotal";
            case 6: return "Status";
            
            default: return null;
        }
    }
}
