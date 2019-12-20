package shopping;

import java.rmi.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/shop")
public class ShopService{

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readItem(@PathParam("id") String name){
		try{
			ShopKeeper client = (ShopKeeper)Naming.lookup("rmi://localhost/shopping/shopKeeper");
			ItemInfo info = client.getItemInfo(name);
			if(info == null)
				return Response.status(404).build();
			return Response.ok(info).build();
		}catch(Exception e){
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response writeOrder(OrderInput input){
		try{
			ShopKeeper client = (ShopKeeper)Naming.lookup("rmi://localhost/shopping/shopKeeper");
			ItemInfo info = client.getItemInfo(input.item);
			if(info == null || input.quantity > info.currentStock)
				return Response.status(404).build();
			float discount = client.getBulkDiscount(input.quantity);
			OrderOutput order = new OrderOutput();
			order.payment = input.quantity * info.unitPrice * (1 - discount / 100);
			return Response.ok(order).build();
		}catch(Exception e){
			return Response.serverError().entity(e.getMessage()).build();
		}

	}
}


