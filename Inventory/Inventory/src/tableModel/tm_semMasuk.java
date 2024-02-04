package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.sementara_masuk;

public class tm_semMasuk extends AbstractTableModel{
    private List<sementara_masuk> list = new ArrayList<>();
    
    public void tambahData(sementara_masuk semMasuk) {
        list.add(semMasuk);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, sementara_masuk semMasuk) {
        list.add(row, semMasuk);
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
    
    public void setData(List<sementara_masuk> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, sementara_masuk semMasuk) {
        list.set(index, semMasuk);
        fireTableRowsUpdated(index, index);
    }
    
    public sementara_masuk getData(int index) {
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
            case 0: return list.get(rowIndex).getMdl_brg().getKode_barang();
            case 1: return list.get(rowIndex).getMdl_brg().getNama_barang();
            case 2: return list.get(rowIndex).getMdl_brg().getSatuan();
            case 3: return list.get(rowIndex).getMdl_brg().getHarga();
            case 4: return list.get(rowIndex).getMdl_mdbm().getJml_masuk();
            case 5: return list.get(rowIndex).getMdl_mdbm().getSubtotal_masuk();
            
            default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Kode Barang";
            case 1: return "Nama Barang";
            case 2: return "Satuan";
            case 3: return "Harga";
            case 4: return "Jumlah";
            case 5: return "Subtotal";
            
            default: return null;
        }
    }
}
