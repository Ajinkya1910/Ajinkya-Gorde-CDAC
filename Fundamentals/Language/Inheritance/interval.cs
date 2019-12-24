using System;

//a part of the definition of this class can appear in other source file
partial class Interval
{
	public int Minutes {get;}

	public int Seconds {get;}

	partial void OnCreate();

	public Interval(int minutes, int seconds)
	{
		Minutes = minutes + seconds / 60;
		Seconds = seconds % 60;
		OnCreate();
	}

	public int GetTime()
	{
		return 60 * Minutes + Seconds;
	}

	public override string ToString()
	{
		return $"{Minutes}:{Seconds:00}";
	}

	public override int GetHashCode() => Minutes + Seconds;
	
	public override bool Equals(object other)
	{
		if(other is Interval that)
		{
			return this.Minutes == that.Minutes && this.Seconds == that.Seconds;
		}

		return false;
	}
}

