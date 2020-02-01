using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DomainApp.Controllers
{
    public class ClockController : Controller
    {
        // GET: Clock/Time
        public ActionResult Time()
        {
            return Content(DateTime.Now.ToString());
        }
    }
}