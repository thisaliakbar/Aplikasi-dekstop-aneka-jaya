package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.sementara_pesan;

public class tm_semPesan extends AbstractTableModel{
    private List<sementara_pesan> list = new ArrayList<>();
    
    public void tambahData(sementara_pesan semPesan) {
        list.add(semPesan);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, sementara_pesan semPesan) {
        list.add(row, semPesan);
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
    
    public void setData(List<sementara_pesan> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, sementara_pesan semPesan) {
        list.set(index, semPesan);
        fireTableRowsUpdated(index, index);
    }
    
    public sementara_pesan getData(int index) {
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
            case 4: return list.get(rowIndex).getMdl_mdp().getJml_pesan();
            case 5: return list.get(rowIndex).getMdl_mdp().getSubtotal_pesan();
//            case 6: return list.get(rowIndex).getMdl_mdp().getStatus();
            
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
//            case 6: return "Status";
            
            default: return null;
        }
    }
}
