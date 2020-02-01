using System;
using System.IO;
using System.Web;

namespace BasicWebApp
{
	public class HtmxToHtmlModule : IHttpModule
	{
		public void Init(HttpApplication app)
		{
			app.BeginRequest += delegate(object sender, EventArgs e)
			{
				string path = app.Context.Request.Path;
				app.Context.RewritePath(path.Replace(".htmx", ".html"));
			};
		}

		public void Dispose() {}
	}

	public class GreetingHandler : IHttpHandler
	{
		private int count = 0;

		public bool IsReusable => true;

		public void ProcessRequest(HttpContext context)
		{

			TextWriter output = context.Response.Output;
			output.WriteLine("<html>");
			output.WriteLine("<head><title>BasicWebApp</title></head>");
			output.WriteLine("<body>");
			output.WriteLine($"<h1>Welcome Visitor {++count}</h1>");
			output.WriteLine($"<b>Time on server: </b>{DateTime.Now}");
			output.WriteLine("</body>");
			output.WriteLine("</html>");
		}
	}

	public class StateHandler : IHttpHandler, System.Web.SessionState.IRequiresSessionState
	{

		public bool IsReusable => false;

		public void ProcessRequest(HttpContext context)
		{
			string name = context.Request.Form["visitor"];
			if(name.Length == 0)
			{
				context.Response.Redirect("welcome.gwh");
				return;
			}

			int? count = (int?)context.Session[name] ?? 1;
			context.Session[name] = count + 1;
			
			TextWriter output = context.Response.Output;
			output.WriteLine("<html>");
			output.WriteLine("<head><title>BasicWebApp</title></head>");
			output.WriteLine("<body>");
			output.WriteLine($"<h1>Hello {name}</h1>");
			output.WriteLine($"<b>Number of greetings: </b>{count}");
			output.WriteLine("</body>");
			output.WriteLine("</html>");

		}
	}	
	
}
