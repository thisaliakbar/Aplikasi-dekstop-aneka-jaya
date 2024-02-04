package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_detail_barangMasuk;

public class tm_detBarangMasuk extends AbstractTableModel {
    private List<model_detail_barangMasuk> list = new ArrayList<>();
    
    public void tambahData(model_detail_barangMasuk mod_detMasuk) {
        list.add(mod_detMasuk);
        fireTableRowsInserted(list.size() - 1, list.size() -  1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    public void perbaruiData(int row, model_detail_barangMasuk mod_detMasuk) {
        list.add(row, mod_detMasuk);
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
    public void setData(List<model_detail_barangMasuk> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, model_detail_barangMasuk mod_detMasuk) {
        list.set(index, mod_detMasuk);
        fireTableRowsUpdated(index, index);
    }
    public model_detail_barangMasuk getData(int index) {
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
            case 0: return list.get(rowIndex).getMod_barangMas_detMas().getNo_masuk();
            case 1: return list.get(rowIndex).getMod_barang_detMas().getKode_barang();
            case 2: return list.get(rowIndex).getMod_barang_detMas().getNama_barang();
            case 3: return list.get(rowIndex).getMod_barang_detMas().getHarga();
            case 4: return list.get(rowIndex).getJml_masuk();
            case 5: return list.get(rowIndex).getSubtotal_masuk();
            
            default: return null;
        }
    }
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "No Masuk";
            case 1: return "Kode Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga";
            case 4: return "Jumlah Masuk";
            case 5: return "Subtotal";
            
            default: return null;
        }
    }
}
