package edu.met.tourism;

public class VisitorModel extends javax.swing.table.AbstractTableModel{

	private Document<Visitor> store = Document.open(Visitor.class, "site.dat");

	@Override
	public int getColumnCount(){
		return 3;
	}

	@Override
	public String getColumnName(int i){
		String[] names = {"Name", "Frequency", "Recent"};
		return names[i];
	}

	@Override
	public int getRowCount(){
		return store.size();
	}

	@Override
	public Object getValueAt(int i, int j){
		Visitor visitor = store.get(i);
		switch(j){
			case 0: return visitor.name;
			case 1: return visitor.frequency;
			default: return visitor.recent;
		}
	}

	public void writeVisitor(String id){
		Visitor visitor = store.find(e -> e.name.equals(id));
		if(visitor == null)
			store.add(new Visitor(id));
		else
			visitor.revisit();
		store.save();
		fireTableDataChanged();
	}
}
