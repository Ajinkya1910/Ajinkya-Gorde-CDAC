using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel;
using System.Windows.Input;

namespace DomainApp
{
    using Models;

    public class MainWindowViewModel : INotifyPropertyChanged
    {
        private VisitorModel model = new VisitorModel();

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        private string _name;

        public string Name
        {
            get { return _name; }
            set
            {
                _name = value;
                OnPropertyChanged("Name");
            }
        }

        public IEnumerable<Visitor> Visitors => model.ReadVisitors();

        class RegisterCommand : ICommand
        {
            internal MainWindowViewModel Parent;

            event EventHandler ICommand.CanExecuteChanged
            {
                add
                {
                    CommandManager.RequerySuggested += value;
                }

                remove
                {
                    CommandManager.RequerySuggested -= value;
                }
            }

            bool ICommand.CanExecute(object parameter)
            {
                return Parent._name?.Length > 3;
            }

            void ICommand.Execute(object parameter)
            {
                Parent.model.WriteVisitor(Parent._name);
                Parent.OnPropertyChanged("Visitors");
            }
        }

        public ICommand Register => new RegisterCommand { Parent = this };
    }
}
