﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ServerApp
{
    public partial class Greeter : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;
        }

        protected void GreetButton_Click(object sender, EventArgs e)
        {
            OutputLabel.Text = $"Good {PeriodDropDownList.Text} {PersonTextBox.Text}";
        }
    }
}