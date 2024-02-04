package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_barang;

//Untuk setting row,col,value
public class tm_barang extends AbstractTableModel{

    private List<model_barang> list = new ArrayList<>();
    
    public void tambahData(model_barang mod_bar) {
        list.add(mod_bar);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_barang mod_bar) {
        list.add(row, mod_bar);
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
    
    public void setData(List<model_barang> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_barang mod_bar) {
        list.set(index, mod_bar);
        fireTableRowsUpdated(index, index);
    }
    
    public model_barang getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
//    private final String[] columnName = {"No", "Kode Barang", "Kode Jenis", "Nama Jenis", "Nama Barang", "Satuan", "Harga", "Stok"};

    @Override
    public int getColumnCount() {
//        return columnName.length;
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        if(columnIndex == 0) {
//            return (rowIndex + 1);
//        } else {
//            switch(columnIndex - 1) {
//            case 0: return list.get(rowIndex).getKode_barang();
//            case 1: return list.get(rowIndex).getMod_jnsBarang().getKode_jenis();
//            case 2: return list.get(rowIndex).getMod_jnsBarang().getNama_jenis();
//            case 3: return list.get(rowIndex).getNama_barang();
//            case 4: return list.get(rowIndex).getSatuan();
//            case 5: return list.get(rowIndex).getHarga();
//            case 6: return list.get(rowIndex).getStok();
//            
//            default: return null;
//            }
//        }
            switch(columnIndex) {
                case 0: return list.get(rowIndex).getKode_barang();
                case 1: return list.get(rowIndex).getMod_jnsBarang().getKode_jenis();
                case 2: return list.get(rowIndex).getMod_jnsBarang().getNama_jenis();
                case 3: return list.get(rowIndex).getNama_barang();
                case 4: return list.get(rowIndex).getSatuan();
                case 5: return list.get(rowIndex).getHarga();
                case 6: return list.get(rowIndex).getStok();
                
                default: return null;
            }
    }
    
    public String getColumnName(int column) {
//        if(column == 0) {
//            return" " + columnName[column];
//        }
//        else {
//            return columnName[column];
//        }
            switch(column) {
                case 0: return "Kode Barang";
                case 1: return "Kode Jenis";
                case 2: return "Nama Jenis";
                case 3: return "Nama Barang";
                case 4: return "Satuan";
                case 5: return "Harga";
                case 6: return "Stok";
                
                default: return null;
            } 
    }
    
}
