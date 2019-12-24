using System;

enum RoomType {Economy, Business, Executive, Deluxe}

struct HotelRoom
{
	public int Number;
	public RoomType Category;
	public bool Taken;
}

static class Program
{
	//read-only reference (to avoid  copy)
	private static void PrintRoom(in HotelRoom room)
	{
		string status = room.Taken ? "Occupied" : "Available";
		Console.WriteLine($"Room {room.Number} is of {room.Category} class and is currently {status}");
		//room.Number = 0;
	}

	//writeable reference
	private static void Checkin(ref HotelRoom room)
	{
		if(!room.Taken)
			room.Taken = true;
	}

	public static void Main()
	{
		HotelRoom myroom;
		myroom.Number = 504;
		myroom.Category = RoomType.Business;
		myroom.Taken = false;

		PrintRoom(myroom);
		Console.WriteLine("Checking into room {0}...", myroom.Number);
		Checkin(ref myroom);
		PrintRoom(myroom);
	}
}
