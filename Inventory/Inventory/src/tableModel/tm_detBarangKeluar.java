package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_detail_barangKeluar;

public class tm_detBarangKeluar extends AbstractTableModel{
    private List<model_detail_barangKeluar> list = new ArrayList<>();
    
    public void tambahData(model_detail_barangKeluar mod_detBarangKeluar) {
        list.add(mod_detBarangKeluar);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil di tambahankan");
    }
    public void perbaruiData(int row, model_detail_barangKeluar mod_detBarangKeluar) {
        list.add(row, mod_detBarangKeluar);
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
    public void setData(List<model_detail_barangKeluar> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, model_detail_barangKeluar mod_detBarangKeluar) {
        list.set(index, mod_detBarangKeluar);
        fireTableRowsUpdated(index, index);
    }
    
    public model_detail_barangKeluar getData(int index) {
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
            case 0: return list.get(rowIndex).getMod_barangKel_detKel().getNo_keluar();
            case 1: return list.get(rowIndex).getMod_barang_detKel().getKode_barang();
            case 2: return list.get(rowIndex).getMod_barang_detKel().getNama_barang();
            case 3: return list.get(rowIndex).getMod_barang_detKel().getHarga();
            case 4: return list.get(rowIndex).getJml_keluar();
            case 5: return list.get(rowIndex).getSubtotal_keluar();
            case 6: return list.get(rowIndex).getKeterangan();
            
            default : return null;
        }
    }
        @Override
        public String getColumnName(int column) {
        switch(column) {
            case 0: return "No Keluar";
            case 1: return "Kode Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga";
            case 4: return "Jumlah Keluar";
            case 5: return "Subtotal Keluar";
            case 6: return "Keterangan";
            
            default: return null;
        }
    }
}