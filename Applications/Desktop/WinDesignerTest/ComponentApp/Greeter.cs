using System.ComponentModel;

namespace ComponentApp
{
    public partial class Greeter : Component, INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public Greeter()
        {
            InitializeComponent();
        }

        public Greeter(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        public string Name { get; set; } = "User";

        public string Interval { get; set; } = "Morning";

        [Browsable(false)]
        public int GreetCount { get; set; }

        public string Greet()
        {
            ++GreetCount;
            return $"Good {Interval} {Name}";
        }

        public void Reset()
        {
            Name = "User";
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs("Name"));

            Interval = "Morning";
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs("Interval"));

            GreetCount = 0;
        }
    }
}

