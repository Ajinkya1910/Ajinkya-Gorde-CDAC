using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace ClientApp
{
    public class MainWindowViewModel : MvvmSupport.ViewModelBase
    {
        private CustomerModel model = new CustomerModel();

        public IEnumerable<Customer> Customers => model.Customers.ToList();

        private Customer _CurrentCustomer;
        public Customer CurrentCustomer
        {
            get => _CurrentCustomer;
            set => SetProperty(ref _CurrentCustomer, value);
        }

        private bool Update_CanExecute(object arg)
        {
            return model.ChangeTracker.HasChanges();
        }

        private void Update_Execute(object arg)
        {
            model.SaveChanges();
        }

        public ICommand Update => DispatchCommand();
    }

}
