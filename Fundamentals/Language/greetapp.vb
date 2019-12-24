Module Program

	Sub Main()
		Dim greeter As New Greeting.Greeter(True)
		Dim name = InputBox("Your Name")
		Dim text = greeter.Greet(name)
		MsgBox(text)
	End Sub

End Module