using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainApp.Models
{
    public class VisitorModel
    {
        Document<Visitor> store = Document.Open<Visitor>("visitors.xml");

        public Visitor[] ReadVisitors()
        {
            return store.ToArray();
        }

        public void WriteVisitor(string name)
        {
            Visitor visitor = store.Find(v => v.Name == name);
            if (visitor == null)
                store.Add(new Visitor { Name = name });
            else
                visitor.Revisit();
            store.Save();
        }
    }
}
