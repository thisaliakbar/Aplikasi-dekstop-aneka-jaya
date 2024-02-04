package tableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.JOptionPane;
import model.model_jenisBarang;

public class tm_jenisBarang extends AbstractTableModel{
    private List<model_jenisBarang> list = new ArrayList<>();
    
    public void tambahData(model_jenisBarang mod_jenBar) {
        list.add(mod_jenBar);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    public void perbaruiData(int row, model_jenisBarang mod_jenBar)  {
        list.add(row, mod_jenBar);
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
    public void setData(List<model_jenisBarang> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, model_jenisBarang mod_jenBar) {
        list.set(index, mod_jenBar);
        fireTableRowsUpdated(index, index);
    }
    public model_jenisBarang getData(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getKode_jenis();
            case 1: return list.get(rowIndex).getNama_jenis();
                   
            default: return null;
        }
    }
    public String getColumnName(int index) {
        switch(index) {
            case 0: return "Kode Jenis";
            case 1: return "Nama Jenis";
            
            default: return null;
        }
    }
    
}
