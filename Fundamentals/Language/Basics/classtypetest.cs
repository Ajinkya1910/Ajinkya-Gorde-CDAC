using System;

enum RoomType {Economy, Business, Executive, Deluxe}

class HotelRoom
{
	public int Number;
	public RoomType Category;
	public bool Taken;
}

static class Program
{
	private static void PrintRoom(HotelRoom room)
	{
		string status = room.Taken ? "Occupied" : "Available";
		Console.WriteLine($"Room {room.Number} is of {room.Category} class and is currently {status}");
	}

	private static void Checkin(HotelRoom room)
	{
		if(!room.Taken)
			room.Taken = true;
	}

	public static void Main()
	{
		HotelRoom myroom = new HotelRoom();
		myroom.Number = 504;
		myroom.Category = RoomType.Business;
		myroom.Taken = false;

		PrintRoom(myroom);
		Console.WriteLine("Checking into room {0}...", myroom.Number);
		Checkin(myroom);
		PrintRoom(myroom);
	}
}
