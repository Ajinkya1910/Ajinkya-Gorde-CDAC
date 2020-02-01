using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ThinClientApp.Models
{
    [Table("Product")]
    public class Product
    {
        [Column("ProductNo")]
        public int Id { get; set; }

        public decimal Price { get; set; }

        public int Stock { get; set; }
    
        //non-virtual navigation property - requires explicit loading
        public ICollection<Order> Orders { get; set; } = new List<Order>();
    }

    [Table("OrderDetail")]
    public class Order
    {
        [Column("OrderNo")]
        public int Id { get; set; }

        public DateTime OrderDate { get; set; }

        public string CustomerId { get; set; }

        [Column("ProductNo")]
        public int ProductId { get; set; }

        public int Quantity { get; set; }
    }


    public class ProductModel : DbContext
    {
        public DbSet<Product> Products { get; set; }

    }
}