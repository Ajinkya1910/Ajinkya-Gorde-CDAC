using System;

namespace DomainApp.Models
{
    public class Visitor
    {
        public string Name { get; set; }

        public int Frequency { get; set; } = 1;

        public DateTime Recent { get; set; } = DateTime.Now;

        public void Revisit()
        {
            Frequency += 1;
            Recent = DateTime.Now;
        }
    }
}
