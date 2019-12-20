package edu.met.tourism;

@javax.inject.Named("visitorModel")
@javax.enterprise.context.RequestScoped
public class VisitorManagedBean implements java.io.Serializable{

	private Document<Visitor> store = Document.open(Visitor.class, "site.dat");

	public Iterable<Visitor> getVisitors(){
		return store;
	}

	public String putVisitor(String id){
		Visitor visitor = store.find(e -> e.name.equals(id));
		if(visitor == null)
			store.add(new Visitor(id));
		else
			visitor.revisit();
		store.save();
		return "index";
	}
}

